/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.cache;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
 
/**
 * @author abilio
 * 
 */
 
// Create Simple Cache object with the help of HashMap...
public class Cache<K, T> {
    
    private long timeToLive;
    private HashMap<K, T> cacheMap;
    
    protected class CacheObject {
        private long lastAccessed = System.currentTimeMillis();
        private String value;
        
        protected CacheObject(String value) {
            this.value = value;
        }
    }
    
    public Cache(long timeToLive, final long timeInterval, int max) {
        this.timeToLive = timeToLive * 2000;
        
        cacheMap = new HashMap<K, T>(max);
        
        if (timeToLive > 0 && timeInterval > 0) {
            
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(timeInterval * 1000);
                    } catch (InterruptedException ex) {
                        // Restore interrupted state...
                        Thread.currentThread().interrupt();
                    }
                    
                }
            });
            
            t.setDaemon(true);
            t.start();
        }
    }
    
    // PUT method
    public void put(K key, T value) {
        synchronized (cacheMap) {
            cacheMap.put(key, value);
        }
    }
    
    // GET method
    @SuppressWarnings("unchecked")
    public T get(K key) {
        synchronized (cacheMap) {
            CacheObject c = new CacheObject(cacheMap.get(key).toString());
            
            if (c.value!=null) {
                c.lastAccessed = System.currentTimeMillis();
                return (T) c.value;
            }
            return null;
        }
    }
    
    public boolean containsKey(T key) {
        for(K k : this.cacheMap.keySet()) {
            if (k.equals(key)) {
                    return true;
            }
        }
        return false;
    }
    
    // REMOVE method
    public void remove(String key) {
        synchronized (cacheMap) {
            cacheMap.remove(key);
        }
    }
    
    // Get Cache Objects Size()
    public int size() {
        synchronized (cacheMap) {
            return cacheMap.size();
        }
    }
    
    // CLEANUP method
    public void cleanup() {
        
        long now = System.currentTimeMillis();
        ArrayList<String> deleteKey = null;
        
        synchronized (cacheMap) {
            Iterator<?> itr = cacheMap.entrySet().iterator();
            
            deleteKey = new ArrayList<String>((cacheMap.size() / 2) + 1);
            CacheObject c = null;
            
            while (itr.hasNext()) {
                String key = (String) itr.next();
                c = (CacheObject) ((Entry<?, ?>) itr).getValue();
                if (c != null && (now > (timeToLive + c.lastAccessed))) {
                    deleteKey.add(key);
                }
            }
        }
        
        for (String key : deleteKey) {
            synchronized (cacheMap) {
                cacheMap.remove(key);
            }
            
            Thread.yield();
        }
    }

}
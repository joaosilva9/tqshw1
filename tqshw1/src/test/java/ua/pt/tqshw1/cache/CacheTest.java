/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.cache;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abilio
 */
public class CacheTest {
    
    public CacheTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class Cache.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Object key = "key";
        Object value = "val";
        Cache instance = new Cache(15,15,15);
        assertEquals(0, instance.size());
        assertEquals(false, instance.containsKey(key));
        instance.put(key, value);
        assertEquals(true, instance.containsKey(key));
        assertEquals(1, instance.size());
    }

    /**
     * Test of get method, of class Cache.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Object key = "key";
        Object value = "val";
        Cache instance = new Cache(15,15,15);
        
        assertEquals(false, instance.containsKey(key));
        instance.put(key, value);
        assertEquals(true, instance.containsKey(key));
        
        Object expResult = value;
        Object result = instance.get(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of containsKey method, of class Cache.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        Object key = "key";
        Cache instance = new Cache(15,15,15);
        boolean expResult = false;
        boolean result = instance.containsKey(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class Cache.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Cache instance = new Cache(15,15,15);
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of cleanup method, of class Cache.
     */
    @Test
    public void testCleanup() {
        System.out.println("cleanup");
        Cache instance = new Cache(15,15,15);
        instance.cleanup();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
}

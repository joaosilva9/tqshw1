/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1;

/**
 *
 * @author abilio
 */

import io.github.bonigarcia.seljup.SeleniumExtension;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class WebTestCase {
    
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeEach
  public void setUp() throws Exception {
    
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWebTestCase() throws Exception {
    driver.get("http://localhost:8080/");
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Castelo Branco");
    driver.findElement(By.id("mySelect")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Previsão de Tempo'])[1]/following::fieldset[1]")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Aveiro");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Beja");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Braga");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Bragança");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Castelo Branco");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Coimbra");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Évora");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Faro");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Guarda");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Leiria");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Lisboa");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Portalegre");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Porto");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Santarém");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Setúbal");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Viana do Castelo");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Vila Real");
    driver.findElement(By.id("mySelect")).click();
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Viseu");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Funchal");
    driver.findElement(By.id("mySelect")).click();
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Porto Santo");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Ponta Delgada");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Angra do Heroísmo");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Horta");
    driver.findElement(By.id("mySelect")).click();
    new Select(driver.findElement(By.id("mySelect"))).selectByVisibleText("Santa Cruz das Flores");
    driver.findElement(By.id("mySelect")).click();
  }

  @AfterEach
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}


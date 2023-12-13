package com.example.HappyTailsTestSuite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class DeleteAPet {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "lib\\win\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	  }

  @Test
  public void testDeleteAPet() throws Exception {
    driver.get("http://ec2-18-117-111-108.us-east-2.compute.amazonaws.com:8080/webproject-happytails/HomePage");
    driver.findElement(By.linkText("Adoption Form")).click();
    driver.get("http://ec2-18-117-111-108.us-east-2.compute.amazonaws.com:8080/webproject-happytails/adoptionForm.html");

    Thread.sleep(200);
    
    
    driver.findElement(By.name("petId")).click();
    driver.findElement(By.name("petId")).clear();
    driver.findElement(By.name("petId")).sendKeys("14");
    driver.findElement(By.name("adoptionPurpose")).click();
    driver.findElement(By.name("adoptionPurpose")).clear();
    driver.findElement(By.name("adoptionPurpose")).sendKeys("Pet delete.");

    Thread.sleep(200);
    
    
    driver.findElement(By.xpath("//input[@value='Adopt']")).click();
    driver.get("http://ec2-18-117-111-108.us-east-2.compute.amazonaws.com:8080/webproject-happytails/AdoptionFormHB");
  }

  @After
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

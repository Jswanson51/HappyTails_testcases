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

public class NavigateFromSearchResultsToInsertPage {
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
  public void testNavigateFromSearchResultsToInsertPage() throws Exception {
    driver.get("http://ec2-18-117-111-108.us-east-2.compute.amazonaws.com:8080/webproject-happytails/HomePage");

    Thread.sleep(200);
    
    
    driver.findElement(By.linkText("Search Pets")).click();
    driver.get("http://ec2-18-117-111-108.us-east-2.compute.amazonaws.com:8080/webproject-happytails/simpleSearchHB.html");

    Thread.sleep(200);
    
    
    driver.findElement(By.xpath("//input[@value='Search']")).click();
    driver.get("http://ec2-18-117-111-108.us-east-2.compute.amazonaws.com:8080/webproject-happytails/SimpleSearchHB");

    Thread.sleep(200);
    
    
    driver.findElement(By.linkText("Insert Pets")).click();
    driver.get("http://ec2-18-117-111-108.us-east-2.compute.amazonaws.com:8080/webproject-happytails/simpleInsertHB.html");
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

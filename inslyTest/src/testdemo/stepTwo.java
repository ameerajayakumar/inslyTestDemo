package testdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class stepTwo {
	
	public String baseUrl = "https://signup.int.staging.insly.training/signup";
    String driverPath = "/Users/dafodilequeen/Seleniumgecko/geckodriver";
    public WebDriver driver ; 
    Properties obj = new Properties();
    String password;
    String email = "testdemo6@gmail.com";
    String company = "CompanyTest6";
  
	
  @Test(priority=1)
  public void companyDetails() throws InterruptedException {
	  
      String companyname = obj.getProperty("CompanyName");
      driver.findElement(By.id(companyname)).sendKeys(company);
      
      String country = obj.getProperty("Country");
      String selectedCountry = obj.getProperty("CountrySelect");
      Select dropC = new Select(driver.findElement(By.id(country)));
      dropC.selectByVisibleText("United Kingdom");
	  assertTrue(driver.findElement(By.xpath(selectedCountry)).isDisplayed(),"Country is not selected");
	  
	  Thread.sleep(5000);
	  String inslyAddress = obj.getProperty("InslyAddress");
	  String expectedAddress = company.toLowerCase();
	  String actualAddress = driver.findElement(By.id(inslyAddress)).getAttribute("value");
	  Assert.assertEquals(actualAddress, expectedAddress);

      String companyProfile = obj.getProperty("CompanyProfile");
      Select dropProfile = new Select(driver.findElement(By.id(companyProfile)));
      dropProfile.selectByVisibleText("Insurance Brokerage Company");
      
      String employees = obj.getProperty("NoOfEmployees");
      Select dropEmployee = new Select(driver.findElement(By.id(employees)));
      dropEmployee.selectByVisibleText("101-500");
      
      String description = obj.getProperty("PersonDescription");
      Select dropDescription = new Select(driver.findElement(By.id(description)));
      dropDescription.selectByVisibleText("I am a tech guy");
	 
  }
  
  @Test(priority=2)
  public void administratorDetails() {
	  
	  String adminEmail = obj.getProperty("AdminEmail");
      driver.findElement(By.id(adminEmail)).sendKeys(email);
      
      String adminName = obj.getProperty("AdminName");
      driver.findElement(By.id(adminName)).sendKeys("Test Demo");
      
      String suggestPass = obj.getProperty("SuggestPass");
      driver.findElement(By.xpath(suggestPass)).click();
      String generatedPass = obj.getProperty("GeneratedPass");
      password = driver.findElement(By.xpath(generatedPass)).getText();
      String alertOk = obj.getProperty("AlertOk");
      driver.findElement(By.xpath(alertOk)).click();
      
      String adminPhone = obj.getProperty("AdminPhone");
      driver.findElement(By.id(adminPhone)).sendKeys("9874453621");
	  
  }
  
  @Test(priority=3)
  public void termsAndConditions() throws InterruptedException {
	  
	  String checkTnC = obj.getProperty("CheckTnC");
      driver.findElement(By.xpath(checkTnC)).click();
      
      String checkPrivacy = obj.getProperty("CheckPrivacy");
      driver.findElement(By.xpath(checkPrivacy)).click();
      
      String checkData = obj.getProperty("CheckData");
      driver.findElement(By.xpath(checkData)).click();
      
      String termsConditionsLink = obj.getProperty("TermsConditionsLink");
      String tnCAgree = obj.getProperty("TnCAgree");
      driver.findElement(By.xpath(termsConditionsLink)).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath(tnCAgree)).click();
      
      String privacyLink = obj.getProperty("PrivacyLink");
      driver.findElement(By.xpath(privacyLink)).click();
      
      Thread.sleep(2000);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      String privacydiv = obj.getProperty("PrivacyDiv");
      js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)",driver.findElement(By.xpath(privacydiv)));
      
      Thread.sleep(2000);
      String privacyClose = obj.getProperty("PrivacyClose");
      driver.findElement(By.xpath(privacyClose)).click();

      String signupButton = obj.getProperty("SignupButton");
      String expectedClassName="primary signup-btn";
      String activeButton = driver.findElement(By.id(signupButton)).getAttribute("class");
	  Assert.assertEquals(activeButton, expectedClassName);
	  
  }
  
  @Test(priority=4)
  public void signUpComplete() throws InterruptedException {
	  
	  String signupButton = obj.getProperty("SignupButton");
	  driver.findElement(By.id(signupButton)).click();
	  Thread.sleep(20000);
	  
	  String loginUser = obj.getProperty("LoginUser");
      driver.findElement(By.id(loginUser)).sendKeys(email);
      String loginPass = obj.getProperty("LoginPass");
      driver.findElement(By.id(loginPass)).sendKeys(password);
      String loginButton = obj.getProperty("LoginButton");
      driver.findElement(By.id(loginButton)).click();
      String url = driver.getCurrentUrl();
      Assert.assertTrue((url.contains(company.toLowerCase())&&url.contains("/dashboard")), "URL mismatch!");
      
	  
  }
  
  @BeforeTest
  public void launchBrowser() {
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
  }
  
  @BeforeTest
  public void locators() throws IOException {
 	 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"//src/application.properties");
 	 obj.load(objfile);
  }

  @AfterTest
  public void terminateBrowser(){
       driver.close();
   }

}

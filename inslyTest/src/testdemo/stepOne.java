package testdemo;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.*;
//import org.apache.log4j.Logger;

public class stepOne {
	
    public String baseUrl = "https://signup.int.staging.insly.training/signup";
    String driverPath = "/Users/dafodilequeen/Seleniumgecko/geckodriver";
    public WebDriver driver ; 
    Properties obj = new Properties();
   // private static Logger Log = Logger.getLogger(inslyTestDemo.class.getName());
     
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
     
      @Test
      public void verifySignUpPageTitles() { 
    	  
    	  //page title
    	  System.out.println("Verifying Page Title");
    	  String title = obj.getProperty("PageTitle");
          String expectedTitle = "Sign up and start using";
          String actualTitle = driver.findElement(By.xpath(title)).getText();
          Assert.assertEquals(actualTitle, expectedTitle);
          
          //find subtitle
    	  System.out.println("Verifying Title Substring");
    	  String subtitle = obj.getProperty("TitleSubstring");
    	  String subexpectedTitle = "No credit card required at this point. Cancel anytime.";
          String subactualTitle = driver.findElement(By.xpath(subtitle)).getText();
          Assert.assertEquals(subactualTitle, subexpectedTitle);
          
          //CompanyTitle
          System.out.println("Verifying Company Title");
          String companytitle = obj.getProperty("CompanyTitle");
    	  String companyexpectedTitle = "Company";
          String companyactualTitle = driver.findElement(By.xpath(companytitle)).getText();
          Assert.assertEquals(companyactualTitle, companyexpectedTitle);
          
          //AddUserTitle
          System.out.println("Verifying Add User Title");
          String usertitle = obj.getProperty("AddUserTitle");
    	  String userexpectedTitle = "Add user";
          String useractualTitle = driver.findElement(By.xpath(usertitle)).getText();
          Assert.assertEquals(useractualTitle, userexpectedTitle);
          
          //AdminTitle
          System.out.println("Verifying Admin Title");
          String admintitle = obj.getProperty("AdminTitle");
    	  String adminexpectedTitle = "Administrator account details";
          String adminactualTitle = driver.findElement(By.xpath(admintitle)).getText();
          Assert.assertEquals(adminactualTitle, adminexpectedTitle);
          
          //TermsnConditions
          System.out.println("Verifying Terms n Conditions Title");
          String terms = obj.getProperty("TnCTitle");
    	  String termsexpectedTitle = "Terms and conditions";
          String termsactualTitle = driver.findElement(By.xpath(terms)).getText();
          Assert.assertEquals(termsactualTitle, termsexpectedTitle);
     }
      
      @Test
      public void verifySignUpPageElements() {
    	  
    	  //companyName
          System.out.println("Verifying Company Name field is present");
          String companyname = obj.getProperty("CompanyName");
    	  assertTrue(driver.findElement(By.id(companyname)).isDisplayed(),"Company Name field is not present");

    	  //country
          System.out.println("Verifying Country field is present");
          String country = obj.getProperty("Country");
    	  assertTrue(driver.findElement(By.id(country)).isDisplayed(),"Country field is not present");

    	  //inslyAddress
          System.out.println("Verifying insly address field is present");
          String inslyad = obj.getProperty("InslyAddress");
    	  assertTrue(driver.findElement(By.id(inslyad)).isDisplayed(),"Insly Address field is not present");

    	  //CompanyProfile
          System.out.println("Verifying Company Profile field is present");
          String companyprofile = obj.getProperty("CompanyProfile");
    	  assertTrue(driver.findElement(By.id(companyprofile)).isDisplayed(),"Company Profile field is not present");

    	  //NoOfEmployees
          System.out.println("Verifying NumberOfEmployees field is present");
          String employees = obj.getProperty("NoOfEmployees");
    	  assertTrue(driver.findElement(By.id(employees)).isDisplayed(),"NumberOfEmployees field is not present");

    	  //PersonDescription
          System.out.println("Verifying Person Description field is present");
          String description = obj.getProperty("PersonDescription");
    	  assertTrue(driver.findElement(By.id(description)).isDisplayed(),"Person Description field is not present");

    	  //inviteButton
          System.out.println("Verifying Invite button is present");
          String invite = obj.getProperty("InviteButton");
    	  assertTrue(driver.findElement(By.id(invite)).isDisplayed(),"Invite Button is not present");

    	  //NewUserAlert
    	  System.out.println("Verifying New user alert is present");
          String userAlert = obj.getProperty("NewUserAlert");
    	  assertTrue(driver.findElement(By.xpath(userAlert)).isDisplayed(),"New User Alert is not present");

    	  //AdminEmail
    	  System.out.println("Verifying Admin email field is present");
          String adminEmail = obj.getProperty("AdminEmail");
    	  assertTrue(driver.findElement(By.id(adminEmail)).isDisplayed(),"Admin email field is not present");

    	  //AdminName
    	  System.out.println("Verifying Admin name field is present");
          String adminName = obj.getProperty("AdminName");
    	  assertTrue(driver.findElement(By.id(adminName)).isDisplayed(),"Admin name field is not present");

    	  //Password
    	  System.out.println("Verifying Password field is present");
          String pass = obj.getProperty("Password");
    	  assertTrue(driver.findElement(By.id(pass)).isDisplayed(),"Password field is not present");
    	  
    	  //PasswordSuggest
    	  System.out.println("Verifying Password suggestion link is present");
          String passSuggest = obj.getProperty("SuggestPass");
    	  assertTrue(driver.findElement(By.xpath(passSuggest)).isDisplayed(),"Password suggestion link is not present");

    	  //PasswordRepeat
    	  System.out.println("Verifying Password repeat field is present");
          String passRepeat = obj.getProperty("PassRepeat");
    	  assertTrue(driver.findElement(By.id(passRepeat)).isDisplayed(),"Password repeat field is not present");

    	  //AdminPhone
    	  System.out.println("Verifying Admin phone field is present");
          String phone = obj.getProperty("AdminPhone");
    	  assertTrue(driver.findElement(By.id(phone)).isDisplayed(),"Admin phone field is not present");

    	  //CheckTnC
    	  System.out.println("Verifying TnC checkbox is present");
          String tnC = obj.getProperty("CheckTnC");
    	  assertTrue(driver.findElement(By.xpath(tnC)).isDisplayed(),"TnC checkbox is not present");

    	  //CheckPrivacy
    	  System.out.println("Verifying Privacy checkbox is present");
          String privacy = obj.getProperty("CheckPrivacy");
    	  assertTrue(driver.findElement(By.xpath(privacy)).isDisplayed(),"Privacy checkbox is not present");

    	  //CheckData
    	  System.out.println("Verifying Data checkbox is present");
          String data = obj.getProperty("CheckData");
    	  assertTrue(driver.findElement(By.xpath(data)).isDisplayed(),"Data checkbox is not present");

    	  //PrivacyAlert
    	  System.out.println("Verifying Privacy alert is present");
          String privacyAlert = obj.getProperty("PrivacyAlert");
    	  assertTrue(driver.findElement(By.xpath(privacyAlert)).isDisplayed(),"Privacy Alert is not present");

    	  //SignupButton
    	  System.out.println("Verifying Signup button is present");
          String signupButton = obj.getProperty("SignupButton");
    	  assertTrue(driver.findElement(By.id(signupButton)).isDisplayed(),"Signup button is not present");

      }
     @AfterTest
     public void terminateBrowser(){
          driver.close();
      }
}
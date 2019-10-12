package com.OrangeHRMLoginTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginTest {
	
	WebDriver driver=null;
	 String url="http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/auth/login";
	  	
		@Given("^Open firefox browser and navigate to OrangeHRM application$")
		public void Open_firefox_browser_and_navigate_to_OrangeHRM_application() {
		    
			System.setProperty("webdriver.gecko.driver", "./DriverFiles/geckodriver.exe");
			driver= new FirefoxDriver();
			driver.get(url);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
		}

		@When("^Login application by enter username and password and click on signin$")
		public void Login_application_by_enter_username_and_password_and_click_on_signin()  {
			
			driver.findElement(By.id("txtUsername")).sendKeys("mahesh");
			driver.findElement(By.id("txtPassword")).sendKeys("mahesh_01");
			driver.findElement(By.id("btnLogin")).click();
		}

		@Then("^User should be able to successfull login to the application and close the application$")
		public void User_should_be_able_to_successfull_login_to_the_application_and_close_the_application() throws InterruptedException, IOException {
			
			try {
			String	 expwelcome_text="Welcome";
			System.out.println("expected welcome element text is :"+ expwelcome_text);
			Thread.sleep(2000);
			WebElement welcome=driver.findElement(By.linkText("Welcome Admin"));
			String actwelcome_text=welcome.getText();
			
			System.out.println("actual welcome element text is :"+ actwelcome_text);
			
			if(actwelcome_text.contains(expwelcome_text))
			{
				System.out.println("Loggedin to OrangeHRM _ pass");
			}else {
				System.out.println("Loggedin to OrangeHRM _fail");
			}
			
			Thread.sleep(10000);
			TakesScreenshot ts = (TakesScreenshot)driver;
			File screenshot=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("E:\\JavaProgrammes\\Cucumber1\\Screenshot\\pass.png"));
			
			
			welcome.click();
			
			driver.findElement(By.linkText("Logout")).click();
			
			driver.close();
			
		}catch(Exception e) {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File screenshot=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("E:\\JavaProgrammes\\Cucumber1\\Screenshot\\failed.png"));
			
			String actual_error=driver.findElement(By.id("spanMessage")).getText();
			System.out.println("actual error messge is :"+actual_error);
			String expected_error="Invalid credentials";
			System.out.println("expected error messge is :"+expected_error);
			
			if(actual_error.equals(expected_error)) {
				System.out.println("login fuctionality failed ");
				driver.close();
			}
		}
			
			
		}
		
}


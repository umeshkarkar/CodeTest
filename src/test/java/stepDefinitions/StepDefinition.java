package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.RegistrationPage;

import resources.BaseClass;
import testData.ExcelReader;

public class StepDefinition extends BaseClass{

	public RegistrationPage rp;
	public WebDriverWait wait;
	
	@Given("^User is on landing page and click on Sign in$")
	public void user_is_on_landing_page_and_click_on_Sign_in() throws Throwable {
	    driver =initializeBrowser();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
	}

	@When("^User create an account with \"([^\"]*)\" address$")
	public void user_create_an_account_with_address(String emailAddress) throws Throwable {
	    
		LandingPage lp =new LandingPage(driver);
			
			lp.clickOnSignIn().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			lp.getEmailAddress().sendKeys(emailAddress);
			lp.clickOnCreateAccount().click();
			//Assert.assertEquals("Login", "Login - My Store");
	}

	@Then("^Navigate to Register page and enter all details to register site$")
	public void navigate_to_Register_page_and_enter_all_details_to_register_site() throws Throwable {
	    
		rp =new RegistrationPage(driver);
			
			rp.selectGender();
			rp.setCustFirstName().sendKeys(ExcelReader.getvalue("cust_FirstName"));
			rp.setCustLastName().sendKeys(ExcelReader.getvalue("cust_LastName"));
			rp.setPassword().sendKeys(ExcelReader.getvalue("password"));
			rp.selectDay();
			rp.selectMonth();
			rp.selectYear();
			rp.selectCheckBox().click();
			rp.setFirstname().sendKeys(ExcelReader.getvalue("firstName"));
			rp.setLastname().sendKeys(ExcelReader.getvalue("lastName"));
			rp.setCompany().sendKeys(ExcelReader.getvalue("company"));
			rp.setAddress().sendKeys(ExcelReader.getvalue("address"));
			rp.setCity().sendKeys(ExcelReader.getvalue("city"));
			rp.setState();
			rp.setPostalCode().sendKeys(ExcelReader.getvalue("postalCode"));
			rp.setMobileNum().sendKeys(ExcelReader.getvalue("mobileNum"));
			rp.setRefAddress().sendKeys(ExcelReader.getvalue("refAddress"));
			rp.clickSubmitBtn().click();
	}

	@Then("^Validate correct name and surname is displayed on landing lage$")
	public void validate_correct_name_and_surname_is_displayed_on_landing_lage() throws Throwable {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			rp.validateDetailsName();
			rp.validateDetailsSurname();
	}

}

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	public WebDriver driver;
	
	private By genderM=By.id("id_gender1");
	private By genderF=By.id("id_gender2");
	private By cust_firstName =By.cssSelector("input#customer_firstname");
	private By cust_lastName =By.id("customer_lastname");
	private By password =By.id("passwd");
	private By days =By.id("days");
	private By months =By.id("months");
	private By years =By.id("years");
	private By checkBox =By.id("optin");
	private By firstName= By.id("firstname");
	private By lastName= By.id("lastname");
	private By company =By.id("company");
	private By address =By.id("address1");
	private By city =By.id("city");
	private By state =By.id("id_state");
	private By postalCode =By.id("postcode");
	private By country =By.id("id_country");
	private By mobileNum =By.id("phone_mobile");
	private By refAddress =By.id("alias");
	private By submitButton =By.xpath("//button[@id='submitAccount']");
	private By viewDetails =By.xpath("//a[@class='account']");
	
	//constructor
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectGender()
	{
		String gender="male";
		if(gender.equalsIgnoreCase("male"))
		{
			driver.findElement(genderM).click();
		}
		if(gender.equalsIgnoreCase("female"))
		{
			driver.findElement(genderF).click();
		}
	}
	
	public WebElement setCustFirstName()
	{
		return driver.findElement(cust_firstName);
	}
	
	public WebElement setCustLastName()
	{
		return driver.findElement(cust_lastName);
	}

	public WebElement setPassword()
	{
		return driver.findElement(password);
	}

	public void selectDay() throws InterruptedException
	{
		Select list =new Select(driver.findElement(days));
		
		List<WebElement> daysList=list.getOptions();

		for(WebElement day:daysList)
		{	
			String oneDay =day.getText();
			if(oneDay.equalsIgnoreCase("4  "))
			{	
				day.click();
				break;
			}
		}
		} 
	
	public void selectMonth()
	{
		Select list =new Select(driver.findElement(months));
		
		List<WebElement> monthsList=list.getOptions();

		for(WebElement month:monthsList)
		{	
			String oneMonth =month.getText();
			if(oneMonth.equalsIgnoreCase("May "))
			{	
				month.click();
				break;
			}
		}
	}
	
	public void selectYear()
	{
		Select list =new Select(driver.findElement(years));
		
		List<WebElement> yearList=list.getOptions();
		
		for(WebElement year:yearList)
		{	
			String oneYear =year.getText();
			if(oneYear.equalsIgnoreCase("2020  "))
			{	
				year.click();
				break;
			}
		}
	}
	
	public WebElement selectCheckBox()
	{
		return driver.findElement(checkBox);
	}
	
	public WebElement setFirstname()
	{
		driver.findElement(firstName).clear();
		return driver.findElement(firstName);
	}
	
	public WebElement setLastname()
	{
		driver.findElement(lastName).clear();
		return driver.findElement(lastName);
	}
	
	public WebElement setCompany()
	{
		return driver.findElement(company);
	}
	
	public WebElement setAddress()
	{
		return driver.findElement(address);
	}
	
	public WebElement setCity()
	{
		return driver.findElement(city);
	}
	
	public void setState()
	{
		Select list =new Select(driver.findElement(state));
		
		List<WebElement> stateList=list.getOptions();
		//System.out.println("List of state: " +stateList.size());

		for(WebElement state:stateList)
		{	
			String oneState =state.getText();
			if(oneState.equalsIgnoreCase("California"))
			{	
				state.click();
				break;
			}
		}
	}
	
	public WebElement setPostalCode()
	{
		return driver.findElement(postalCode);
	}
	
	public WebElement setCountry()
	{
		return driver.findElement(country);
	}
	
	public WebElement setMobileNum()
	{
		return driver.findElement(mobileNum);
	}
	
	public WebElement setRefAddress()
	{ 
		 driver.findElement(refAddress).clear();
		 return driver.findElement(refAddress);
		
	}
	
	public WebElement clickSubmitBtn()
	{
		return driver.findElement(submitButton);
	}
	
	public WebElement validateDetails()
	{
		return driver.findElement(viewDetails);
	}
}

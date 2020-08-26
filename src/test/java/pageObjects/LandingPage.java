package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
	
	public WebDriver driver;
	
	private By signIn =By.xpath("//a[@class='login']");
	private By emailAddress =By.id("email_create");
	private By createAccountButton =By.id("SubmitCreate");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement clickOnSignIn()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getEmailAddress()
	{
		return driver.findElement(emailAddress);
	}
	
	public WebElement clickOnCreateAccount()
	{
		return driver.findElement(createAccountButton);
	}
	

}

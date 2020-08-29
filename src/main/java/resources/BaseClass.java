package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeBrowser() throws IOException
	{
		prop =new Properties();   
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	
		String browserName = prop.getProperty("browser");	
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	if(browserName.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
		return driver;
	
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}

package MavenPackage;

import java.io.IOException;

import javax.xml.validation.Validator;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.ReusableFunctions;

public class validateTitle extends ReusableFunctions{
	public WebDriver driver;
//	 public static Logger log =LogManager.getLogger(base.class.getName());
	Logger log = Logger.getLogger(Validator.class);

	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
	     log.info("Driver is initialized");
			
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Navigated to Home page");
	}
	@Test
	
	public void validateAppTitle() throws IOException
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Login | Salesforce");
	   log.info("Successfully validated Text message");
		 System.out.println("Test completed");
		 
		
	
		
		}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	

	
}

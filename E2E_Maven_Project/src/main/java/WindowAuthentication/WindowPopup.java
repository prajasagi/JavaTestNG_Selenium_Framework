package WindowAuthentication;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowPopup {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\WebDrivers\\Chrome\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // to handle window windows authentication pop up
        // https://<username>:<password>@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
	}

}

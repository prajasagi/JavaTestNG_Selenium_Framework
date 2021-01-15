package WindowAuthentication;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		String downloadPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\WebDrivers\\Chrome\\chromedriver.exe");
	    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("profile.default_content_settings.popups", 0);
	    chromePrefs.put("download.default_directory", downloadPath);
	    ChromeOptions options=new ChromeOptions();
	    options.setExperimentalOption("prefs",chromePrefs);
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://altoconvertpdftojpg.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[class*=btn--choose]")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\paone\\eclipse-workspace\\E2EProjectCucumber\\E2EProjectCucumber\\AutoIt\\FileUpload.exe");
        Thread.sleep(3000);
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/section[1]/div/div/div[2]/div[3]/button")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/section[1]/div/div/div[2]/div[3]/button")).click();
    //    Thread.sleep(4000);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Download Now')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Download Now')]")).click();
        Thread.sleep(3000);
        File f=new File(downloadPath+"/Result.zip");
        if(f.exists())
        {
        	System.out.println("yes file downloaded");
        }
        else
        {
        	
        }

        
	}

}

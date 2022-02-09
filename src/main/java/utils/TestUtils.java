package utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestUtils{
	
	public static WebDriver driver;

    public void setDriver(){
    	
    	String browser = getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/DriverExeFile/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/DriverExeFile/geckodriver.exe");
			driver = new FirefoxDriver();
		}//end of if else 
		
		driver.manage().window().maximize();
		driver.get(getProperty("appUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().deleteAllCookies();
		
		//Verify Login Page Title 
		String Title = driver.getTitle();
		Assert.assertTrue(Title.equals("Log In - Paylocity Benefits Dashboard"));
		
		//Get UserName and Password from Property File
		paylocityLogin(getProperty("username"),getProperty("password"));
		
	}//end of setDriver Method

    public void paylocityLogin(String username, String Password) {
		WebElement userName = driver.findElement(By.id("Username"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		 
	 	userName.clear();
		userName.sendKeys(username);
		password.clear();
		password.sendKeys(Password);
		submitBtn.click();
		
    }//end of Login Method
    
    public void quitDriver()  {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
    }//end of tearDown Method
	
	
	public String getProperty(String key) {
        String value = null;
        Properties prop = loadProperty("testRun");
        value = prop.getProperty(key);
        if (value == null) {
            String env = prop.getProperty("testEnv");
            prop = loadProperty(env);
            value = prop.getProperty(key);
        }

        return value;
    }//end of getProp Method

    public Properties loadProperty(String propFileName) {
        Properties prop = new Properties();
        String filePath = ".\\src\\main\\resources\\Properties\\"+ propFileName +".properties";
        try {
            File file = new File(filePath);
            FileInputStream stream = new FileInputStream(file);
            prop.load(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
        
    }//end of loadProp method

}//end of class

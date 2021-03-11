package YahooGmailPractice.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static String myBrowser ="Chrome";
	public static String myUrl ="https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin";
	
	//We will use this method in test class to open browser
	public static void executeBrowser() throws Exception{
		invokeMyBrowser();
	}
	
	
	 //Calling driver
		public static void invokeMyBrowser() throws Exception {
			getDriver().get(myUrl);
			getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			getDriver().manage().window().maximize();
		}
		
		
		 //Initiate driver 
		public static WebDriver getDriver() throws Exception {
			if (driver == null) {
				if (myBrowser.equalsIgnoreCase("Firefox")) {
					System.setProperty("webdriver.firefox.marionette", "E:\\chromeDriver\\chromedriver.exe");
					driver = new FirefoxDriver();
				} else if (myBrowser.equalsIgnoreCase("Chrome")) {
					System.setProperty("webdriver.chrome.driver", "E:\\chromeDriver\\chromedriver.exe");
					driver = new ChromeDriver();
				} else if (myBrowser.equalsIgnoreCase("IE")) {
					System.setProperty("webdriver.ie.driver", "E:\\chromeDriver\\chromedriver.exe");
					driver = new InternetExplorerDriver();
				} else {
					throw new Exception("Browser is not correct");
				}
			}
			return driver;
		}
		
	  
		
}

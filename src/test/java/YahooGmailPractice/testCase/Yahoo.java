package YahooGmailPractice.testCase;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import YahooGmailPractice.utilities.BaseClass;
import junit.framework.Assert;

public class Yahoo extends BaseClass{
	public static String password="null";
	public static String actualUiUser;
	public static String email="acharjeeauntor@yahoo.com";
	public static String expectedUser="Auntor";
	public static String subject="Hello11";
	public static String body="Hello World11";
	public static String anotherGmail="acharjeeontu@gmail.com";
	
	
	
	

@BeforeTest
public static void initiateDriver() throws Exception {
	executeBrowser();
}
	
@Test(priority=1)
public static void login() throws InterruptedException {
	//WebElement userName = driver.findElement(By.xpath("//input[@id='login-username']"));  // we can use this way also
	driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@id='login-signin']")).click();
	driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys(password);
	driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
	Thread.sleep(1000);
}

@Test(priority=2)
public static void loginValidate() throws InterruptedException {
	actualUiUser = driver.findElement(By.xpath("//span[@role='presentation']")).getText();
	if(actualUiUser.contains(expectedUser)) {
		Assert.assertTrue(true);
		Thread.sleep(1000);
		System.out.println("Account Login validation success");
		driver.findElement(By.xpath("//a[@id='ybarMailLink']")).click();
		
	}else {
		Assert.fail();
		System.out.println("Account Login validation Failed");
	}
}

@Test(priority=3)
public static void composeEmail() throws InterruptedException {
	driver.findElement(By.xpath("//a[normalize-space()='Compose']")).click();
	driver.findElement(By.xpath("//input[@id='message-to-field']")).sendKeys(anotherGmail);
	driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(subject);
	driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys(body);
	driver.findElement(By.xpath("//button[@title='Send this email']")).click();
	System.out.println("Composs and Email Sent Complete");
	Thread.sleep(1000);
}


@Test(priority=4)
public static void validateSent() throws InterruptedException {
	driver.findElement(By.xpath("//span[contains(text(),'Sent')]")).click();
	Thread.sleep(1000);
	String actualEmail = driver.findElement(By.xpath("//span[contains(text(),'acharjeeontu@gmail.com')]")).getText();
	String actualSubject = driver.findElement(By.xpath("//span[@title='"+subject+"']")).getText();
	String actualBody = driver.findElement(By.xpath("//div[contains(text(),'"+body+"')]")).getText();
	
	if(actualEmail.contains(anotherGmail)&&actualSubject.contains(subject)&&actualBody.contains(body)) {
		Assert.assertTrue(true);
		System.out.println("Email Sent properly");
	}else {
		Assert.fail();
		System.out.println("Email dose not Sent properly");
	}
	
	
}

@Test(priority=5)
public void logout() throws InterruptedException {
	driver.findElement(By.xpath("//label[@id='ybarAccountMenuOpener']")).click();
	driver.findElement(By.xpath("//a[@class='_yb_tdi30 _yb_po6e2 _yb_m78yl _yb_16g61 _yb_1delc']")).click();
	System.out.println("LogOut From Yahoo...");
	driver.navigate().to("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	Thread.sleep(1000);
}
	
	
	
}

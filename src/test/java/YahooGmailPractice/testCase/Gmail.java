package YahooGmailPractice.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import YahooGmailPractice.utilities.BaseClass;
import junit.framework.Assert;

public class Gmail extends BaseClass{
	public static String email="acharjeeontu@gmail.com";
	public static String password="null";
	public static String actualUiUser;
	public static String expectedUser="Ontu Acharjee";
	public static String subject="Hello";
	public static String body="Hello World";
	public static String replyMessage="I am confirming that i receive your email";
	public static String receiveEmailSubject;
	public static String receiveEmailBody;
	
	
@Test(priority=6)
public static void login() throws InterruptedException {
	System.out.println("This call");
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
//	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(email);
//	driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
//	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
//	driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc']//div[@class='VfPpkd-RLmnJb']")).click();
	Thread.sleep(1000);
	System.out.println("login To Gmail ");
}
	
	
	
@Test(priority=7)
public static void loginValidate() throws InterruptedException {
	driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
	actualUiUser = driver.findElement(By.xpath("//div[@class='gb_mb gb_nb']")).getText();
	if(actualUiUser.contains(expectedUser)) {
		Assert.assertTrue(true);
		System.out.println("Application user = "+actualUiUser + "matches with given expected user="+expectedUser);
		Thread.sleep(1000);
		
	}else {
		Assert.fail();
		System.out.println("Application user = "+actualUiUser + "do not matche with given expected user="+expectedUser);
	}
	
	System.out.println(" login validation into gmail ");
}	
	
	
	
@Test(priority=8)
public static void ValidateReceiveEmail() throws InterruptedException {
	
	driver.findElement(By.xpath("//tr[@id=':2f']")).click();
	receiveEmailSubject = driver.findElement(By.xpath("//h2[normalize-space()='"+subject+"']")).getText();
	receiveEmailBody = driver.findElement(By.xpath("//div[@dir='ltr'][normalize-space()='"+body+"']")).getText();
	if(receiveEmailSubject.contains(subject)&&receiveEmailBody.contains(body)) {
		Assert.assertTrue(true);
		System.out.println("receive Email Subject= "+receiveEmailSubject + "matches with given expected receive Email Subject ="+body);
		System.out.println("Email Receive Validation complete");
		Thread.sleep(1000);
		
	}else {
		Assert.fail();
		System.out.println("receive Email Subject= "+receiveEmailSubject + "do not match with given expected receive Email Subject ="+body);
	}
	
	System.out.println("Validate Receiving email");
}	
	

@Test(priority=9)
public static void replayBack() throws InterruptedException {
	driver.findElement(By.xpath("//span[@id=':nb']")).click();
	driver.findElement(By.xpath("//div[@id=':sl']")).sendKeys(replyMessage);
	driver.findElement(By.xpath("//div[@id=':r6']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//tr[@id=':2f']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Sign out']")).click();
	Thread.sleep(1000);
	System.out.println("Complete reply.. and Logout");
}

}


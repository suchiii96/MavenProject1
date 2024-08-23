package com.abc.Ecommerce.FirstMavenproject;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//Data Driven Testing using TestNG and Parametrisation
public class LoginPage {
	ChromeDriver driver;
	
	@Test
	public void OpenAndNavigate() 
	{
		driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}	
		
	
	@Test
	public void Userlogin()
		{
		
	WebElement MyAccount = driver.findElement(By.linkText("My Account"));
		MyAccount.click();
		
	WebElement login = driver.findElement(By.linkText("Login"));
	login.click();
	
	
		}
	@Parameters({"email","password"})
	@Test
	public void loginCredentialswithValidData(String ourEmail,String ourPassword) 
	
	{
		
	driver.findElement(By.id("input-email")).sendKeys(ourEmail);
	driver.findElement(By.id("input-password")).sendKeys( ourPassword);
	driver.findElement(By.xpath("//input[@value='Login']")).click();
		
			}
	
	@Parameters({"email1","password"})
	@Test
	
	public void loginCredentialswithInValidEmail(String wrongMail, String actualpass)
	{
		
	driver.findElement(By.id("input-email")).sendKeys(wrongMail);
	driver.findElement(By.id("input-password")).sendKeys(actualpass);
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	
	@Parameters({"email","pass"})
	@Test	
	public void loginCredentialswithInvalidPass(String validEmail, String Wrongpass)
	
	{
		
	driver.findElement(By.id("input-email")).sendKeys(validEmail);
	driver.findElement(By.id("input-password")).sendKeys(Wrongpass);
	driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}
	
	
		
		
	

	
}




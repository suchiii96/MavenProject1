package com.abc.Ecommerce.FirstMavenproject;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;



//Data Driven Testing using TestNG and Parametrisation
public class RegisterPage {
	ChromeDriver driver;
	
	@Test
	
	public void OpenAndNavigate() 
	{
		driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		
	}
	
   @Test
   public void UserRegistration()
		{
		
		WebElement MyAccount = driver.findElement(By.linkText("My Account"));
		MyAccount.click();
		WebElement Register = driver.findElement(By.linkText("Register"));
		Register.click();
		
			}
		
	@Parameters({"firstname","lastname","email","telephone"})	
	@Test
	public void chechWithValidData(String myfirstname, String mylastname,String myemail,String mytelephone)
	{
	driver.findElement(By.id("input-firstname")).sendKeys(myfirstname);	
	driver.findElement(By.id("input-lastname")).sendKeys(mylastname);
	driver.findElement(By.id("input-email")).sendKeys(myemail);
	driver.findElement(By.id("input-telephone")).sendKeys(mytelephone);
	
	
	}
		@Parameters("password")
		@Test
	public void confirmPassWord(String myPassword) 
		{
		driver.findElement(By.id("input-password")).sendKeys(myPassword);	
		driver.findElement(By.id("input-confirm")).sendKeys(myPassword);
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		}
	
	
	
}






	

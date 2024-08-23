package com.abc.Ecommerce.FirstMavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterAndLogin {
	ChromeDriver driver;


@Test(dataProvider="ProvideDataaToRegister")
public void CheckRegisterPage(String email, String pass) throws InterruptedException
{
	driver= new ChromeDriver();
	driver.get("https://tutorialsninja.com/demo/");
	WebElement MyAccount = driver.findElement(By.linkText("My Account"));
	MyAccount.click();
	Thread.sleep(3000);
	WebElement Register = driver.findElement(By.linkText("Register"));
	Register.click();
	driver.findElement(By.id("input-email")).sendKeys(email);
	driver.findElement(By.id("input-password")).sendKeys(pass);
	
	driver.quit();
	
}
/*@Test(dataProvider="ProvideDataToLogin",dataProviderClass=DataProviderClass.class)
public void checkLoginPage(String myemail, String mypass)
{
driver= new ChromeDriver();
driver.get("https://tutorialsninja.com/demo/");
WebElement MyAccount = driver.findElement(By.linkText("My Account"));
MyAccount.click();
WebElement login = driver.findElement(By.linkText("Login"));
login.click();
driver.findElement(By.id("input-email")).sendKeys(myemail);
driver.findElement(By.id("input-password")).sendKeys(mypass);


}*/


	
	
	@DataProvider(parallel=true)
	public Object[][] ProvideDataaToRegister()
	
	{
		
		Object registerData[][]= {{"martin@gmail.com","martin123"},{"martin@gmail.com","mart.1"},{"mart..gmail","martin123"},
				{"mart@.com","1234"}};
		
		
		return registerData;
		
	}
	
	/*@DataProvider(parallel=true)
		 public Object [][] ProvideDataToLogin()
		 {
			 
			 Object loginData[][]= {{"Suchithra.chandra96@gmail.com","Suchi@1234"},{"Suchithra.chandra96@gmail.com","suc."},{"such.gmail","Suchi@1234"},
						{"such@1234","suc"}};
			 
			 return  loginData;*/
		 }

	
	
	












package com.abc.Ecommerce.FirstMavenproject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ShoppingCart {
	

	ChromeDriver driver,driver3;
	ExtentReports extentreport;
	ExtentTest extenttest;
	
	@BeforeTest
	public void createReport() {
		
	    extentreport= new ExtentReports();
		ExtentSparkReporter extentsparkreporter= new ExtentSparkReporter("./myreports1/passmynewreports1.html");
		extentreport.attachReporter(extentsparkreporter);
		
		extentreport= new ExtentReports();
		ExtentSparkReporter failextentsparkreporter= new ExtentSparkReporter("./myreports1/failmynewreports1.html");
		extentreport.attachReporter(failextentsparkreporter);
		
		extentsparkreporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
		
		failextentsparkreporter.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
	}
	
	@AfterTest
	public void  actualReport() {
			
			extentreport.flush();
		}
	
	@BeforeTest
	 public void openBrowser() {
		
	extenttest=extentreport.createTest("Adding products","This test case checks wheather products are adding" +"and verify the cart");
	extenttest.assignAuthor("aaryan");
	extenttest.assignDevice("asus windows 11");
	extenttest.assignCategory("functional test case");	
	
	extenttest.log(Status.INFO,"chrome browser will get open");
	driver= new ChromeDriver();
	extenttest.log(Status.PASS,"chrome browser will got opened");
	
	extenttest.log(Status.INFO,"tutorial ninja website will get open ");
	driver.get("https://tutorialsninja.com/demo/");
	extenttest.log(Status.PASS,"tutorial ninja website will got open");
	 
	extenttest.log(Status.INFO,"window is in minimized mode ");
	driver.manage().window().maximize();
	extenttest.log(Status.PASS,"window is in maximized mode ");
	
    }
	@Test
	public void AddToCart()  {
		
	extenttest.log(Status.INFO,"product name will get enter in the search tab ");
	driver.findElement(By.name("search")).sendKeys("tab");
	driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	extenttest.log(Status.PASS,"product should get displayed ");
	
	extenttest.log(Status.INFO," searched product  will get added to the cart ");
	driver.findElement(By.xpath("//div[@class='button-group']/button[@type='button']")).click();
	extenttest.log(Status.PASS,"searched product  will got added to the cart ");
	
	}
	
	@Test(priority=1)
	public void verifyCartContents() throws InterruptedException
	
	{
	Thread.sleep(6000);
	extenttest.log(Status.INFO," retriving the title of the product displayed ");
	String ProductToAdd =driver.findElement(By.linkText("Samsung Galaxy Tab 10.1")).getText();
	//String productPrice=driver.findElement(By.xpath("//*[@id='content']/div[3]/div/div/div[2]/div[1]/p[2]")).getText();
	
	extenttest.log(Status.INFO," shopping cart contents will get verified ");
	driver.findElement(By.xpath("//*[@id='cart']/button")).click();
	driver.findElement(By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]")).click();
	extenttest.log(Status.PASS,"shopping cart contents got verified ");
	
	extenttest.log(Status.INFO," retriving the title of the product added to cart ");
	String ProductInCart=driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
	//String  productPriceInCart=driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
	
	if(ProductToAdd.equals(ProductInCart)) {
		
		System.out.println("product name verified");
	}
	
	else {
		
		System.out.println("product not matched");
		
	}
	driver.close();
	
}
	@Test(priority=2)
	public void cartVerifyWithInvalidLocator() throws IOException {
		
		ExtentTest extenttestnew =extentreport.createTest("product search","This test case checks the output when giving invalid locator");	
		extenttest.assignAuthor("ammu");
		extenttest.assignDevice("mackbook pro chrome 118");
		extenttest.assignCategory("functional test case");
		
		try {
			
		
		driver3= new ChromeDriver();
		driver3.get("https://tutorialsninja.com/demo/");
		
		extenttestnew.log(Status.INFO,"a new product name will get enter in the tab ");	
		driver3.findElement(By.name("search")).sendKeys("tab");
		driver3.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		extenttestnew.log(Status.PASS,"product name got entered ");
		
		extenttestnew.log(Status.INFO,"product  will added to cart ");	
		driver3.findElement(By.xpath("//div[@class='button-group']")).click();
		extenttestnew.log(Status.PASS,"product is not added to cart");
		
		}
		
		catch(NoSuchElementException e){
			
		extenttestnew.log(Status.FAIL,"The above element was unable to locate ");
			
			
		}
		
		File myFirstScreenshot=((TakesScreenshot)driver3).getScreenshotAs(OutputType.FILE);
	    
	    File destinationFile=new File("./myScreenshots1/fail.png");
	    
	    FileUtils.copyFile(myFirstScreenshot,destinationFile);
	     
	    extenttestnew.addScreenCaptureFromPath("C:/Users/anees/eclipse-workspace/FirstMavenproject/myScreenshots1/fail.png");
	     //Thread.sleep(3000);
	     
	    driver3.close();
	     
		
		
		
	}
		
	
	
	
	
	}

	
	
	
	 
			   
		  
	  
	  
	
	













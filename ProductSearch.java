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

public class ProductSearch {
	
	ChromeDriver driver,driver2;
	ExtentReports extentreport;
	ExtentTest extenttest;
	ExtentTest extenttestnew;
	
	@BeforeTest
	public void createReport() {
		
	    extentreport= new ExtentReports();
		ExtentSparkReporter extentsparkreporter= new ExtentSparkReporter("./myreports/mynewreports.html");
		
		extentreport.attachReporter(extentsparkreporter);
	}
	
	@AfterTest
	public void  actualReport() {
			
			extentreport.flush();
		}
		
		
	@BeforeTest
	public void openBrowser() {
		
	 extenttest=extentreport.createTest("searching products","This test case checks wheather search" +"results are properly getting");
	 extenttest.assignAuthor("suchi");
	 extenttest.assignDevice("Hp chrome 118");
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
	public void ProductSearches()
	
	{
	extenttest.log(Status.INFO,"product name will get enter in the search tab ");
	driver.findElement(By.name("search")).sendKeys("tab");
	driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	extenttest.log(Status.PASS,"product should get displayed ");
		
	}	
	@Test
	public void VerifySearchResults() {
		
	 extenttest.log(Status.INFO,"verifying whether the product is displayed or not ");
	 WebElement newProduct =driver.findElement(By.linkText("Samsung Galaxy Tab 10.1"));
	 newProduct.isDisplayed();
	 extenttest.log(Status.PASS,"verified that the product is displayed ");
	 
	 extenttest.log(Status.INFO,"chrome browser will get closed ");
	 driver.close();
	 extenttest.log(Status.PASS,"chromebrowser will got closed ");
	 
	 extenttest.log(Status.INFO,"The test case got passed ");
		
		
	}
	@Test
	public void searchWithInvalidLocator() throws IOException {
		
	extenttestnew =extentreport.createTest("product search","This test case checks the output when giving invalid locator");	
	extenttestnew.assignAuthor("aneesh");
	extenttestnew.assignDevice("mackbook chrome 119");
	extenttestnew.assignCategory("functional test case");
	
	try {
		
    driver2= new ChromeDriver();
	driver2.get("https://tutorialsninja.com/demo/");
	extenttestnew.log(Status.INFO,"a new product name will get enter in the tab ");	
	driver2.findElement(By.name("abcdef")).sendKeys("hiii");
	extenttestnew.log(Status.PASS,"product name got entered ");
	  
		}
	catch(NoSuchElementException e) {
		
	extenttestnew.log(Status.FAIL,"The above element was unable to locate ");
		
		}
	
     File myFirstScreenshot=((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
    
     File destinationFile=new File("./myScreenshots/fail.png");
    
     FileUtils.copyFile(myFirstScreenshot,destinationFile);
     
     extenttestnew.addScreenCaptureFromPath("C:/Users/anees/eclipse-workspace/FirstMavenproject/myScreenshots/fail.png");
     //Thread.sleep(3000);
     
     driver2.close();
     
	
	
	}
	
}



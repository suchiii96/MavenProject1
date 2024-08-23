package com.abc.Ecommerce.FirstMavenproject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abc.listeners.NewListeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Listeners(NewListeners.class)
public class CheckOutProcess {
	
	public static ChromeDriver driver,driver4;
	ExtentReports extentreport;
	ExtentTest extenttest;
	
	@BeforeTest
	public void createReport() {
		
	extentreport= new ExtentReports();
	
	ExtentSparkReporter extentsparkreporter= new ExtentSparkReporter("./myreports2/passmynewreports1.html");
	extentreport.attachReporter(extentsparkreporter);
	
	extentreport= new ExtentReports();
	ExtentSparkReporter extentsparkreporter2= new ExtentSparkReporter("./myreports2/failmynewreports1.html");
	extentreport.attachReporter(extentsparkreporter2);
	
	extentsparkreporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
	
	extentsparkreporter2.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	}
	
	@AfterTest
	public void  actualReport() {
			
			extentreport.flush();
		}
	
			
	@BeforeTest
	public void openingBrowser() {
		
	extenttest=extentreport.createTest("Checkout process","This test case checks wheather checkout process" +"is sucessfully done");
	extenttest.assignAuthor("amlu");
	extenttest.assignDevice("lenovo windows 11");
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
	public void ProductCheckoutProcess() throws InterruptedException {
		
	extenttest.log(Status.INFO,"product name will get enter in the search tab ");	
	driver.findElement(By.name("search")).sendKeys("HP LP30");
	extenttest.log(Status.PASS,"product should get displayed ");
	
	extenttest.log(Status.INFO," searched product  will get added to the cart ");
	driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	driver.findElement(By.xpath("//div[@class='button-group']/button[@type='button']")).click();
	extenttest.log(Status.PASS,"searched product  will got added to the cart ");
	
	extenttest.log(Status.INFO," checkout process started with product in cart ");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='button-cart']")).click();
	driver.findElement(By.xpath("//*[@id='cart']/button")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]")).click();
	driver.findElement(By.linkText("Checkout")).click();
	
	extenttest.log(Status.INFO," login the account with existing customer option ");
	Thread.sleep(3000);
	WebElement email=driver.findElement(By.id("input-email"));
	email.sendKeys("suchithra.chandra@gmail.com");
	WebElement password=driver.findElement(By.id("input-password"));
	password.sendKeys("suchi@1234");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	extenttest.log(Status.PASS,"sucessfully logged in to the account ");
	
	
	
	Thread.sleep(3000);
	
	/*if(driver.findElement(By.xpath("//*[@id='collapse-payment-address']/div/form/div[1]/label/input")).isSelected())
	{
		//driver.findElement(By.xpath("//*[@id=\'button-payment-address\']")).click();
		driver.findElement(By.xpath("//*[@id=\'collapse-payment-address\']/div/form/div[3]/label/input")).click();
	}
	else
	{*/ 
	
	    extenttest.log(Status.INFO," adding a new shipping adress ");
		driver.findElement(By.xpath("//*[@id=\'collapse-payment-address\']/div/form/div[3]/label/input")).click();
		driver.findElement(By.name("firstname")).sendKeys("suchi");
		driver.findElement(By.name("lastname")).sendKeys("aneesh");
		driver.findElement(By.name("address_1")).sendKeys("akshsyanagar,banglore");
		driver.findElement(By.name("city")).sendKeys("bangalore");
		driver.findElement(By.name("firstname")).sendKeys("suchi");
		
		WebElement dropDown=driver.findElement(By.id("input-payment-country"));
		 dropDown.click();
		 Select Country= new Select(dropDown);
		 Country.selectByVisibleText("India");
		 
		 Thread.sleep(3000);
		 WebElement dropDown1=driver.findElement(By.id("input-payment-zone"));
		 dropDown1.click();
		 Select State= new Select(dropDown1);
		 State.selectByValue("1489");
		 driver.findElement(By.xpath("//*[@id=\'button-payment-address\']")).click();
		 extenttest.log(Status.PASS,"shipping adress sucessfully added ");
		 
			
		 extenttest.log(Status.INFO," by default selecting the delivery adress ");
		 Thread.sleep(3000);
		 if(driver.findElement(By.name("shipping_address")).isSelected())
		 	{
			 driver.findElement(By.id("button-shipping-address")).click();
		 	}
			 
		 else
		 {
			driver.findElement(By.name("shipping_address")).click();
			driver.findElement(By.id("button-shipping-address")).click();
			
			extenttest.log(Status.PASS,"delivery adress sucessfully selected ");
			 
			}
		 
		    extenttest.log(Status.INFO," selecting the delivery method ");
		    Thread.sleep(3000);
		    driver.findElement(By.id("button-shipping-method")).click(); 
		    extenttest.log(Status.PASS," delivery method selected ");
			 
		    
		    extenttest.log(Status.INFO," selecting the payment method ");
		    Thread.sleep(3000);
		    driver.findElement(By.name("agree")).click(); 
		    driver.findElement(By.id("button-payment-method")).click(); 
		    extenttest.log(Status.PASS," payment method selected ");
		    
		    extenttest.log(Status.INFO," order is going to confirm");
		    Thread.sleep(3000);
		    driver.findElement(By.id("button-confirm")).click(); 
		    extenttest.log(Status.PASS," order confirmed");
		    
		    extenttest.log(Status.INFO," chrome browser will get closed");
		    driver.close();
		    extenttest.log(Status.PASS," chromebrowser will got closed");
		    
		    driver.close();
		    
		 
		 }
	
	@Test
	public void CheckOUtWithInvalidLocator() throws IOException {
		
		
		ExtentTest extenttestnew =extentreport.createTest("product search","This test case checks the output when giving invalid locator");	
		extenttest.assignAuthor("sujin");
		extenttest.assignDevice("asus chrome 119");
		extenttest.assignCategory("functional test case");
		
		try {
			
		
	    driver4= new ChromeDriver();
		driver4.get("https://tutorialsninja.com/demo/");
		driver4.manage().window().maximize();
		
		extenttestnew.log(Status.INFO,"a new product name will get enter in the tab ");	
		driver4.findElement(By.name("search")).sendKeys("HP LP30");
		extenttestnew.log(Status.PASS,"product name got entered ");
		
		extenttestnew.log(Status.INFO,"product  will added to cart ");	
		driver4.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		extenttestnew.log(Status.PASS,"product is not added to cart");
		}
		
		catch(NoSuchElementException e) {
			
		extenttestnew.log(Status.FAIL,"The above element was unable to locate ");
			
		}
		
        File myFirstScreenshot=((TakesScreenshot)driver4).getScreenshotAs(OutputType.FILE);
	    
	    File destinationFile=new File("./myScreenshots2/fail.png");
	    
	    FileUtils.copyFile(myFirstScreenshot,destinationFile);
	     
	    extenttestnew.addScreenCaptureFromPath("C:/Users/anees/eclipse-workspace/FirstMavenproject/myScreenshots2/fail.png");
	     //Thread.sleep(3000);
	     
	    driver4.close();
		
	}
	
	
}
			 
		 
		 
		 
		 
		 
	
	 
	
		
		
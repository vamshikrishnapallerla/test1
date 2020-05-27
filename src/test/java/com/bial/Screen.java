package com.bial;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class Screen {
	public WebDriver driver ; 
    SoftAssert softAssert = new SoftAssert();
 @BeforeTest
 public void launchBrowser() {
 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\v.krishna.pallerla\\Desktop\\selenium\\chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 20);
 }
	
	@Test
	public void demoOfOtherClassObj() throws Exception{
		driver.get("https://www.google.com/");
		FirstScript obj = new FirstScript();
		obj.verifyTitle();
	}
 @Test
	public void testScreenshot1() throws Exception {
	driver.get("https://www.google.com/");
	Assert.assertEquals(true, false);
//	TakesScreenshot ts = (TakesScreenshot)driver;
//	File source = ts.getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(source, new File("C:\\Users\\v.krishna.pallerla\\Desktop\\Screen.png"));
//	System.out.println("the Screenshot is taken");
}
 
 @AfterMethod
 public void tearDown(ITestResult result)
 {
  
 // Here will compare if test is failing then only it will enter into if condition
 if(ITestResult.FAILURE==result.getStatus())
 {
 try 
 {
 // Create refernce of TakesScreenshot
	 System.out.println("failed");
 TakesScreenshot ts=(TakesScreenshot)driver;
  
 // Call method to capture screenshot
 File source=ts.getScreenshotAs(OutputType.FILE);
  
 // Copy files to specific location here it will save all screenshot in our project home directory and
 // result.getName() will return name of test case so that screenshot name will be same
 FileUtils.copyFile(source, new File(".//Screenshots/"+result.getName()+".png"));
  
 System.out.println("Screenshot taken");
 } 
 catch (Exception e)
 {
  
 System.out.println("Exception while taking screenshot "+e.getMessage());
 } 
  
 }
 
}
}


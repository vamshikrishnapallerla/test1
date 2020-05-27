package com.bial;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public WebDriver driver;
	public String browserType  = "chrome";
	public String url = "https://www.bengaluruairport.com/";
	/**
	 * this method will create browser object
	 * @param browser
	 */
	public void getBrowser(String browser) {
	if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
		this.driver = new FirefoxDriver();
	} else if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
	}
	}
	
	public void getScreenShot(String imageName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		  
		 // Call method to capture screenshot
		 File source=ts.getScreenshotAs(OutputType.FILE);
		  
		 // Copy files to specific location here it will save all screenshot in our project home directory and
		 // result.getName() will return name of test case so that screenshot name will be same
//		 FileUtils.copyFile(source, new File(".//Screenshots/"+imageName+".png"));
		  
		 System.out.println("Screenshot taken");
	}
	public void launchBrowser(){
		getBrowser(browserType);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void getApplicationURL(){
		driver.get(url);
	}
}

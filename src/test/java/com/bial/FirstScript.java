package com.bial;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class FirstScript {

	public String baseUrl = "https://www.bengaluruairport.com/";
    public WebDriver driver ; 
    SoftAssert softAssert = new SoftAssert();
   
    @BeforeTest
    public void launchBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\v.krishna.pallerla\\Desktop\\selenium\\chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 20);
    }
     
  @Test(enabled = false)
  public void verifyTitle() {
	  driver.get(baseUrl);
      String expectedTitle = "Welcome to BIAL | Bangalore International Airport";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      System.out.println("called from other class");
  }

//  @Test
//  public void verifyMoveToOtpPage() {
//	  driver.get("https://www.bengaluruairport.com/corporate/engage-with-us/on-time-performance-report.html");
//	  driver.findElement(By.className("otp__card")).click();
//	  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//	  driver.switchTo().window(tabs2.get(1));
//  }
    
  @Test(enabled = false)
  public void verifyLogo() {
	  driver.get(baseUrl);
	  String actualSrc = driver.findElement(By.cssSelector("img.header__image")).getAttribute("src");
	  String expectedSrc = "https://www.bengaluruairport.com/content/dam/bial/global/logo/bial-logo/kiab-logo.svg";
	  Assert.assertEquals(actualSrc, expectedSrc);
  }
    
    @Test(enabled = false)
    public void verifyAnnouncement() {
    	driver.get(baseUrl);
    	if(driver.findElement(By.className("announcement__section")).getCssValue("display") != "none") {
    		String annSectionCss = driver.findElement(By.className("announcement__section")).getCssValue("display");
    		System.out.println(annSectionCss);
    		if(annSectionCss != "none") {
        		driver.findElement(By.className("announcement__close__link")).click();
        		annSectionCss = driver.findElement(By.className("announcement__section")).getCssValue("display");
        		System.out.println(annSectionCss);
        		Assert.assertEquals(annSectionCss, "none");
        		}
    		}
    }
  
  @Test(enabled = false)
  public void verifyFirstLevelMegaMenu() {
	  driver.get(baseUrl);
	  driver.findElement(By.linkText("FLIGHTS")).isDisplayed();
	  driver.findElement(By.linkText("TRANSPORT")).isDisplayed();
	  driver.findElement(By.linkText("BEFORE YOU FLY")).isDisplayed();
	  driver.findElement(By.linkText("AT THE AIRPORT")).isDisplayed();
	  driver.findElement(By.linkText("PASSENGER SERVICES")).isDisplayed();
	  driver.findElement(By.linkText("CORPORATE")).isDisplayed();
  }
    @Test(enabled = false)
    public void verifyWeatherDetails() {
    	driver.get(baseUrl);
//    	driver.findElement(By.className("weather-icon")).isDisplayed();
    	driver.findElement(By.className("weather-temperature")).isDisplayed();
    	driver.findElement(By.className("weather-description")).isDisplayed();
    	driver.findElement(By.linkText("Sign In")).isDisplayed();
    	driver.findElement(By.className("search-icon")).isDisplayed();
    }
    
  @Test(enabled = false)
  public void verifyHeroBannerText() {
	  driver.get(baseUrl);
	  softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='container hero__banner__title__block']/div/div/div/p[1]/span")).getText(), "EXPLORE.", "p1 failed");
	  softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='container hero__banner__title__block']/div/div/div/p[2]/span")).getText(), "    ENGAGE.", "p2 failed");
	  softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='container hero__banner__title__block']/div/div/div/p[3]/span")).getText(), "        EXPERIENCE.", "p3 failed");
	  softAssert.assertAll();
  }
  
  @Test(enabled = false)
  public void verifyCampaignCarousel() {
	  driver.get(baseUrl);
	  driver.findElement(By.cssSelector(".component.campaign__carousel__slider")).isDisplayed();
  }
  @Test
  public void verifyMultiItemCarousel() {
	  driver.get(baseUrl);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("document.querySelector(\".component.multi-item-carousel\").scrollIntoView()");
	  driver.findElement(By.cssSelector(".component.multi-item-carousel")).isDisplayed();
	  EventFiringWebDriver efw = new EventFiringWebDriver(driver);
	  efw.executeScript("document.querySelector(\".card-deck.multiCarousel-inner\").scrollBy(200,0)");
	  //card-deck multiCarousel-inner
  }
    
  @Test(enabled = false)
  public void verifyFooter() {
	  driver.get(baseUrl);
	  softAssert.assertEquals(driver.findElement(By.className("footer__heading__contactus")).getText(), "CONNECT WITH US", "footer text failed");
	  driver.findElement(By.xpath("//a[@class=\"footer__social__icons__linkedin\"]")).isDisplayed();
	  driver.findElement(By.xpath("//a[@class=\"footer__social__icons__youtube\"]")).isDisplayed();
	  driver.findElement(By.xpath("//a[@class=\"footer__social__icons__facebook\"]")).isDisplayed();
	  driver.findElement(By.xpath("//a[@class=\"footer__social__icons__instagram\"]")).isDisplayed();
	  driver.findElement(By.xpath("//a[@class=\"footer__social__icons__twitter\"]")).isDisplayed();
	  softAssert.assertEquals(driver.findElement(By.className("footer__copyright")).getText(), "© 2020 BIAL. All Rights Reserved.", "copyrights text failed");
	  driver.findElement(By.linkText("FAQs")).isDisplayed();
	  driver.findElement(By.linkText("Disclaimer")).isDisplayed();
	  driver.findElement(By.linkText("Contact Us")).isDisplayed();
	  driver.findElement(By.linkText("Terms of Use")).isDisplayed();
	  driver.findElement(By.linkText("Privacy Policy")).isDisplayed();
	  driver.findElement(By.linkText("Copyright Notice")).isDisplayed();
	  softAssert.assertEquals(driver.findElement(By.className("footer__heading__download")).getText(), "Download BLR Airport App", "download text failed");
	  driver.findElement(By.className("footer__logo")).isDisplayed();
	  driver.findElement(By.className("footer__appstore__section")).isDisplayed();
	  softAssert.assertAll();
  }
  @AfterTest
  public void terminateBrowser(){
//      driver.close();
  }

}

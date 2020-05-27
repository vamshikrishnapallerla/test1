package com.bial;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	TestBase obj = new TestBase();
	@BeforeTest
	public void launchBrowser() {
		obj.launchBrowser();
		obj.getApplicationURL();
	}
	@Test
	public void test() {
		obj.driver.findElement(By.linkText("TRANSPORT")).click();
	}
}

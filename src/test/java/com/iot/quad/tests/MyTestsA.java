package com.iot.quad.tests;

import java.awt.Toolkit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.iot.quad.pages.HomePage;

public class MyTestsA {
	
	WebDriver driver ;
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver() ;
		driver.get("http://automationpractice.com/index.php");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        int Width = (int) toolkit.getScreenSize().getWidth();
        int Height = (int) toolkit.getScreenSize().getHeight();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(Width, Height));
	
	}
	
	@Test
	public void assertURL(){
	
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php");
	}
	
	@Test void getNames(){
		HomePage page = new HomePage(driver);
		page.getProductNames().getProductPrices().addnew();
	}
	
	@AfterClass
	public void teardown(){
	if (driver != null) {
		driver.close();
		driver.quit();	
	}
	}

}

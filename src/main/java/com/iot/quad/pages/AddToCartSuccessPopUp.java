package com.iot.quad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartSuccessPopUp {
	
	WebDriver driver ;
	
	@FindBy(className = "icon-ok")
    private WebElement cartSuccessMessage ;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement checkoutStep1 ;

	public AddToCartSuccessPopUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, AddToCartSuccessPopUp.class);
	}
	
	

}

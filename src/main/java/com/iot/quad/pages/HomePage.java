package com.iot.quad.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver ;
	
	@FindBy(id = "center_column")
    private WebElement catalog ;

    @FindBy(className = "blockbestsellers")
    private WebElement bestSellerCatalog ;

    @FindBy(className = "homefeatured")
    private WebElement popularCatalog ;

    // xpath locator to explain custom attribute selection
    // locator explains list of webElements
    @FindBys(@FindBy(xpath = "//ul[@id='homefeatured']//h5[@itemprop='name']"))
    private List<WebElement> productNames ;

    @FindBy(xpath = "//ul[@id='homefeatured']//div[@class='right-block']//div[@itemprop='offers']")
    private List<WebElement> catalogPrices ;
    
    public HomePage(WebDriver driver){
    	this.driver = driver ;
    	PageFactory.initElements(driver, this);
    }
    
    public HomePage openPopularCatalog(){
        popularCatalog.click();
        return new HomePage(driver);
    }

    public HomePage openBestSellerCatalog(){
        bestSellerCatalog.click();
        return new HomePage(driver);
    }

    public HomePage getProductNames(){
        for (WebElement name: productNames) {
            System.out.println("Below product are listed in catalog : " + name.getText());
        }
        return new HomePage(driver);
    }

    public HomePage getProductPrices(){
        for (WebElement price: catalogPrices) {
            System.out.println("Below prices are listed in catalog : " + price.getText());
        }
        return new HomePage(driver);
    }


    public AddToCartSuccessPopUp addnew(){

        WebElement catItem = driver.findElement(By.xpath("(.//ul[@id='homefeatured']//div[@class='product-container'])[3]"));
        WebElement addToCart = driver.findElement(By.xpath("(.//ul[@id='homefeatured']//a[@title='Add to cart'])[3]"));

        Actions action = new Actions(driver);
        action.moveToElement(catItem).build().perform();
        addToCart.click();
        return new AddToCartSuccessPopUp(driver);
        
    }

}

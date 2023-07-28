package com.solvd.qa.carina.solvd_files.petstore.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends ProductPageBase {
    @FindBy(xpath = "//button[contains(@name, 'add')]")
    private ExtendedWebElement addToCartButton;
    @FindBy(xpath = "//h1[contains(@class, 'product-single__title')]")
    private ExtendedWebElement productTitle;
    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]")
    private Header header;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart(){
        addToCartButton.click();
        pause(5);

    }
    public ExtendedWebElement getProductTitle(){
        return productTitle;
    }

    public Header getHeader(){
        return header;
    }
}

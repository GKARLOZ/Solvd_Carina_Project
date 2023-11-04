package com.solvd.qa.carina.solvd_files.petstore.gui.pages.android;


import com.solvd.qa.carina.solvd_files.petstore.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.gui.components.HeaderBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.components.MobileHeader;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    @FindBy(xpath = "//button[contains(@name, 'add')]")
    private ExtendedWebElement addToCartButton;
    @FindBy(xpath = "//h1[contains(@class, 'product-single__title')]")
    private ExtendedWebElement productTitle;
    @FindBy(xpath = "//header[contains(@class,'site-header')]")
    private MobileHeader header;
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart(){
        addToCartButton.click();

    }
    public ExtendedWebElement getProductTitle(){
        return productTitle;
    }

    public HeaderBase getHeader(){
        return header;
    }
}

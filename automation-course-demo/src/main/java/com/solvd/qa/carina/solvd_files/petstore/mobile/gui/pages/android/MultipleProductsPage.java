package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android;


import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common.MultipleProductsPageBase;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MultipleProductsPageBase.class)
public class MultipleProductsPage extends MultipleProductsPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//div[contains(@class,'grid-product__meta')]")
    private List<ExtendedWebElement> productList;
    @FindBy(xpath = "//div[contains(@id,'header')]")
    private Header header;

    public MultipleProductsPage(WebDriver driver){
        super(driver);
    }
    public List<ExtendedWebElement> getProductList(){
        return productList;
    }

    public void printAllProductTitle(){
        for(ExtendedWebElement product: productList){
            LOGGER.info(product.getText());
        }
    }
    public Header getHeader(){
        return header;
    }

    public ProductPage selectProduct(String product) {
        ExtendedWebElement expand;
        String element;

        LOGGER.info("selecting " + product  + " product >>>");
        for(int i = 1; i < productList.size(); i++){
            String currentProduct = productList.get(i-1).getText();

            if(product.equalsIgnoreCase(currentProduct)){
                element=String.format("//div[contains(@class,'grid__item grid-product')][%o]//a",i);
                expand = findExtendedWebElement(By.xpath(element));
                waitUntil(ExpectedConditions.elementToBeClickable(expand.getElement()), 20000);
                expand.click();
                return new ProductPage(driver);
            }

        }
        LOGGER.error("Unable to open Product: " + product);
        return null;

    }


}

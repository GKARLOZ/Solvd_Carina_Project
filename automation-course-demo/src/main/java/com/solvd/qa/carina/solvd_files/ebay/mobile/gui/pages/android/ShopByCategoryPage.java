package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.android;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.ProductPageBase;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.ShopByCategoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShopByCategoryPageBase.class)
public class ShopByCategoryPage extends ShopByCategoryPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id="com.ebay.mobile:id/recycler_view_main")
    private ExtendedWebElement productListContainer;

    @FindBy(id="com.ebay.mobile:id/cell_collection_item")
    private ExtendedWebElement selectedProduct;

    @FindBy(id="com.ebay.mobile:id/textview_primary_0")
    private ExtendedWebElement price;

    public ShopByCategoryPage(WebDriver driver) {
        super(driver);
    }

    public ShopByCategoryPage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }

    public ExtendedWebElement getProductListContainer(){
        return productListContainer;
    }

    public ExtendedWebElement getProduct(){
        return selectedProduct;
    }

    public ProductPageBase swipeUntil(Double idealPrice){

        String numberPrice = price.getText().replaceAll("\\$|\\,","");
        double priceOfProduct = Double.parseDouble(numberPrice);


        while(!(priceOfProduct < idealPrice)){
            swipeInContainer(productListContainer,Direction.UP,850);

            numberPrice = price.getText().replaceAll("\\$|\\,","");
            priceOfProduct = Double.parseDouble(numberPrice);

        }
        selectedProduct.click();
        return new ProductPage(driver);

    }



}

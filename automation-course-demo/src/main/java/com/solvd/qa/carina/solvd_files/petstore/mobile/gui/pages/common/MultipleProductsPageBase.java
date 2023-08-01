package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common;


import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class MultipleProductsPageBase extends AbstractPage {

    public MultipleProductsPageBase(WebDriver driver){
        super(driver);
    }
    public abstract List<ExtendedWebElement> getProductList();
    public abstract void printAllProductTitle();
    public abstract Header getHeader();
    public abstract ProductPage selectProduct(String product);



}

package com.solvd.qa.carina.solvd_files.petstore.gui.components;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.AccountPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.LogInPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.MultipleProductsPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HeaderBase extends AbstractUIObject {


    public HeaderBase(WebDriver driver) {
        super(driver);
    }

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void expandCategory(String category);
    public abstract void openMenu();
    public abstract LogInPageBase openLogin();
    public abstract AccountPageBase openAccountPage();
    public abstract List<ExtendedWebElement> getItemsInCart();
    public abstract void closeCart();
    public abstract void searchItem(String q);
    public abstract ProductPageBase selectFromSearchResults(int item);
    public abstract MultipleProductsPageBase clickCategory(String category);
    public abstract MultipleProductsPageBase clickInnerCategory(String category);
}

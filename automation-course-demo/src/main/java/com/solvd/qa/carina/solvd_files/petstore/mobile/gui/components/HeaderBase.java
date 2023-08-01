package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.components;


import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.AccountPage;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.LogInPage;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.ProductPage;
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
    public abstract LogInPage openLogin();
    public abstract AccountPage openAccountPage();
    public abstract List<ExtendedWebElement> getItemsInCart();
    public abstract void closeCart();
    public abstract void searchItem(String q);
    public abstract ProductPage selectFromSearchResults(int item);

}
package com.solvd.qa.carina.solvd_files.ebay.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ShopByCategoryPageBase extends AbstractPage {
    protected ShopByCategoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ShopByCategoryPageBase selectCategory(String category);
    public abstract ShopByCategoryPageBase selectBrand(String brand);
    public abstract void printAllCategories();
    public abstract ShopByCategoryPageBase selectInnerCategory(String category);

    public abstract ShopByCategoryPageBase maxPrice(String s);
    public abstract void printAllPrices();

    public abstract void getItemAndPrice();


}

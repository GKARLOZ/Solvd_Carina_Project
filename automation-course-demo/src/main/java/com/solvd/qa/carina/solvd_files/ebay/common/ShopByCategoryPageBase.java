package com.solvd.qa.carina.solvd_files.ebay.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ShopByCategoryPageBase extends AbstractPage {
    protected ShopByCategoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectCategory(String category);
    public abstract void selectBrand(String brand);
    public abstract void printAllCategories();
    public abstract void selectInnerCategory(String category);

    public abstract void maxPrice(String s);
    public abstract void printAllPrices();

    public abstract void getItemAndPrice();
    public abstract List<ExtendedWebElement> getPrices();

    public abstract List<ExtendedWebElement> getCategoryLinks();


}

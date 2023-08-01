package com.solvd.qa.carina.solvd_files.ebay.gui.common;

import com.solvd.qa.carina.solvd_files.ebay.gui.desktop.ShopByCategoryPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }
    public abstract ShopByCategoryPage selectFromMenu(String category);
    public abstract ShopByCategoryPage searchItem(String q);

}

package com.solvd.qa.carina.solvd_files.ebay.desktop;

import com.solvd.qa.carina.solvd_files.ebay.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//ul[contains(@class, 'vl-flyout-nav__container')]//a")
    private List<ExtendedWebElement> menuLinks;
    @FindBy(xpath = "//section[contains(@class, 'b-module')][2]/ul/li")
    private List<ExtendedWebElement> categoryLinks;
    @FindBy(xpath = ".//input[@type='submit']")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = ".//input[@type='text']")
    private ExtendedWebElement searchTextField;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }

    public ShopByCategoryPage selectFromMenu(String link) {
        LOGGER.info("selecting " + link + " menu link >>>");
        for (ExtendedWebElement cl : menuLinks) {
            String currentLink = cl.getText();
            if(link.equalsIgnoreCase(currentLink)){
                cl.click();
                return new ShopByCategoryPage(driver);
            }
        }
        LOGGER.error("Unable to open Menu: " + link);
        return null;
    }

    public ShopByCategoryPage searchItem(String q){
        searchTextField.type(q);
        searchButton.click();
        return new ShopByCategoryPage(driver);

    }

}

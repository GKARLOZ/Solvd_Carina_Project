package com.solvd.qa.carina.solvd_files.petstore.gui.components;



import com.solvd.qa.carina.solvd_files.petstore.gui.pages.android.AccountPage;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.android.LogInPage;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.android.MultipleProductsPage;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.android.ProductPage;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.MultipleProductsPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeaderBase.class)
public class MobileHeader extends HeaderBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//button[contains(@aria-controls,'NavDrawer')]")
    private ExtendedWebElement menuButton;
    @FindBy(xpath = "//ul[contains(@role,'navigation')]/li[contains(@class,'mobile-nav__item')]")
    private List<ExtendedWebElement> categoryLinks;
    @FindBy(xpath = "//a[contains(@class,'mobile-nav__link')]")
    private List<ExtendedWebElement> innerCategoryLinks;
    @FindBy(xpath ="//a[contains(@href,'/account')]" )
    private ExtendedWebElement login;
    @FindBy(xpath = "//div[contains(@class,'site-nav')]//a[contains(@href,'/account')]")
    private ExtendedWebElement accountPage;
    @FindBy(xpath = "//*[@id=\"CartContainer\"]//div[contains(@class,'ajaxcart__product appear-animation')]")
    private List<ExtendedWebElement> itemsInCart;
    @FindBy(xpath = "//div[contains(@id,'CartDrawer')]//button[contains(@class,'drawer__close-button')]")
    private ExtendedWebElement exitCart;
    @FindBy(xpath = "//a[contains(@href,'/search')]")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = "//input[contains(@type, 'search')]")
    private ExtendedWebElement searchTextField;
    @FindBy(xpath = "//*[@id=\"PredictiveResults\"]//a[contains(@class,'grid-product__link')]")
    private List<ExtendedWebElement> listOfSearchResults;
    @FindBy(xpath = "//*[@id=\"PredictiveResults\"]//div[contains(@class,'grid__item grid-product')]")
    private ExtendedWebElement firstSearchResult;


    public MobileHeader(WebDriver driver) {
        super(driver);
    }
    public MobileHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getItemsInCart(){
        return itemsInCart;
    }
    public void closeCart(){
        waitUntil(ExpectedConditions.elementToBeClickable(exitCart.getElement()), 20000);
        exitCart.click();
    }
    public ProductPageBase selectFromSearchResults(int item){
        waitUntil(ExpectedConditions.elementToBeClickable(firstSearchResult.getElement()),10000);
        listOfSearchResults.get(item).click();
        return new ProductPage(driver);
    }
    public LogInPage openLogin(){
        login.click();
        return new LogInPage(driver);
    }

    public AccountPage openAccountPage(){
        accountPage.click();
        return new AccountPage(driver);
    }
    public void openMenu(){
        menuButton.click();
    }

    public MultipleProductsPageBase clickCategory(String category) {
        LOGGER.info("selecting " + category + " category >>>");
        for (ExtendedWebElement cl : categoryLinks) {
            String currentCategory = cl.getText();
            if(category.equalsIgnoreCase(currentCategory)){
                waitUntil(ExpectedConditions.elementToBeClickable(cl.getElement()), 20000);
                cl.click();
                return new MultipleProductsPage(driver);

            }
        }
        LOGGER.error("Unable to open category: " + category);
        return null;
    }

    public MultipleProductsPageBase clickInnerCategory(String category) {

        LOGGER.info("selecting " + category + " category >>>");
        for (ExtendedWebElement cl : innerCategoryLinks) {
            String currentCategory = cl.getText();
            if (category.equalsIgnoreCase(currentCategory)) {
                waitUntil(ExpectedConditions.elementToBeClickable(cl.getElement()),20000);
                cl.click();
                return new MultipleProductsPage(driver);

            }
        }
        LOGGER.error("Unable to open category: " + category);
        return null;

    }
    public void expandCategory(String category) {
        ExtendedWebElement expand;
        String element;

        LOGGER.info("selecting " + category + " category >>>");
        for(int i = 1; i < categoryLinks.size(); i++){
            String currentCategory = categoryLinks.get(i-1).getText();

            if(category.equalsIgnoreCase(currentCategory)){
                element = String.format("//li[contains(@class,'mobile-nav__item')][%o]//div[contains(@class,'mobile-nav__toggle')]//button[contains(@class,'collapsible-trigger')]",i);
                expand = findExtendedWebElement(By.xpath(element));
                waitUntil(ExpectedConditions.elementToBeClickable(expand.getElement()), 20000);
                expand.click();
                break;

            }

        }

    }

    public void searchItem(String q){
        searchButton.click();
        searchTextField.type(q);

    }

}

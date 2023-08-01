package com.solvd.qa.carina.solvd_files.petstore.gui.components;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop.AccountPage;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop.LogInPage;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop.MultipleProductsPage;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop.ProductPage;
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

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HeaderBase.class)
public class Header extends HeaderBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[1]/div/button")
    private ExtendedWebElement menuButton;
    @FindBy(xpath = "//*[@id=\"NavDrawer\"]/div/div[2]/ul[1]/li")
    private List<ExtendedWebElement> categoryLinks;
    @FindBy(xpath = "//li/div[2]/div/ul//li/div/a")
    private List<ExtendedWebElement> innerCategoryLinks;
    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[3]/div/div/a[1]")
    private ExtendedWebElement login;
    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[3]/div/div/a[1]")
    private ExtendedWebElement accountPage;
    @FindBy(xpath = "//*[@id=\"CartContainer\"]/div[1]/div")
    private List<ExtendedWebElement> itemsInCart;
    @FindBy(xpath = "//*[@id=\"CartDrawer\"]/form/div[1]/div/div[2]/button")
    private ExtendedWebElement exitCart;
    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[3]/div/div/a[2]")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = "//input[contains(@type, 'search')]")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath = "//*[@id=\"PredictiveResults\"]/div/div/div/div/div/a")
    private List<ExtendedWebElement> listOfSearchResults;

    public Header(WebDriver driver) {
        super(driver);
    }
    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public List<ExtendedWebElement> getItemsInCart(){
        return itemsInCart;
    }
    public void closeCart(){
        exitCart.click();
    }
    public ProductPage selectFromSearchResults(int item){
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

    public MultipleProductsPage clickCategory(String category) {
        LOGGER.info("selecting " + category + " category >>>");
        for (ExtendedWebElement cl : categoryLinks) {
            String currentCategory = cl.getText();
            if(category.equalsIgnoreCase(currentCategory)){
                waitUntil(ExpectedConditions.elementToBeClickable(cl.getElement()), 20000);
                cl.click();
//                cl.pause(10);
                return new MultipleProductsPage(driver);

            }
        }
        LOGGER.error("Unable to open category: " + category);
        return null;
    }

    public MultipleProductsPage clickInnerCategory(String category) {

        LOGGER.info("selecting " + category + " category >>>");
        for (ExtendedWebElement cl : innerCategoryLinks) {
            String currentCategory = cl.getText();
            if (category.equalsIgnoreCase(currentCategory)) {
                waitUntil(ExpectedConditions.elementToBeClickable(cl.getElement()),20000);
                cl.click();
//                cl.pause(10);
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
                    element = String.format("//*[@id=\"NavDrawer\"]/div/div[2]/ul[1]/li[%o]/div[1]/div/button",i);
                    expand = findExtendedWebElement(By.xpath(element));
                    waitUntil(ExpectedConditions.elementToBeClickable(expand.getElement()), 20000);
                    expand.click();
//                    expand.pause(5);
                    break;

                }

            }

    }

    public void searchItem(String q){
        searchButton.click();
        searchTextField.type(q);
        pause(5);

    }



}

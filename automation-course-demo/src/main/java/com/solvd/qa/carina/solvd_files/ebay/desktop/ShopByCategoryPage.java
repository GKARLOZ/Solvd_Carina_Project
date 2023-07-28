package com.solvd.qa.carina.solvd_files.ebay.desktop;

import com.solvd.qa.carina.solvd_files.ebay.common.ShopByCategoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ShopByCategoryPageBase.class)
public class ShopByCategoryPage extends ShopByCategoryPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//section[contains(@class, 'b-module')][2]/ul/li")
    private List<ExtendedWebElement> categoryLinks;
    @FindBy(xpath = "//section[2]/ul//li/a")
    private List<ExtendedWebElement> innerCategoryLinks;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/section[2]//a")
    private List<ExtendedWebElement> brandList;
    @FindBy(xpath = "//span[@class=\"s-item__price\"]")
    private List<ExtendedWebElement> prices;
    @FindBy(xpath = "//div[@class=\"s-item__info clearfix\"]")
    private List<ExtendedWebElement> mobilePhones;
    @FindBy(xpath = "//div[@class=\"s-item__info clearfix\"]//span[@role=\"heading\"]")
    private List<ExtendedWebElement> itemList;

   @FindBy(xpath="//*[@id=\"s0-53-17-0-1-2-6-1-8[3]-0-textrange-endParamValue-textbox\"]")
   private ExtendedWebElement max;

   @FindBy(xpath = "//*[@id=\"s0-53-17-0-1-2-6-1-8[3]-0-textrange\"]/div/div[3]/button")
   private ExtendedWebElement button;


    public ShopByCategoryPage(WebDriver driver) {
        super(driver);
    }

    public ShopByCategoryPage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }

    public List<ExtendedWebElement> getPrices(){
        return prices;
    }

    public List<ExtendedWebElement> getCategoryLinks(){
        return categoryLinks;
    }


    public void selectCategory(String category) {
        LOGGER.info("selecting " + category + " category >>>");
        for (ExtendedWebElement cl : categoryLinks) {
            String currentCategory = cl.getText();
            if(category.equalsIgnoreCase(currentCategory)){
                waitUntil(ExpectedConditions.elementToBeClickable(cl.getElement()), 20000);
                cl.click();
//                cl.pause(10);
                break;
            }
        }

    }

    public void selectInnerCategory(String category) {

        LOGGER.info("selecting " + category + " category >>>");
        for (ExtendedWebElement cl : innerCategoryLinks) {
            String currentCategory = cl.getText();
            if(category.equalsIgnoreCase(currentCategory)){
                waitUntil(ExpectedConditions.elementToBeClickable(cl.getElement()),20000);
                cl.click();
//                cl.pause(10);
                break;

            }
        }
    }

    public void selectBrand(String brand){
        for(ExtendedWebElement b: brandList){
            String currentBrand = b.getText();
            if(brand.equalsIgnoreCase(currentBrand)){
                waitUntil(ExpectedConditions.elementToBeClickable(b.getElement()),20000);
                b.click();
//                b.pause(15);
                break;

            }
        }

    }
    public void getItemAndPrice(){

        for(int i=2; i < 49; i++){

            ExtendedWebElement item = findExtendedWebElement(
                    By.xpath(String.format("//*[@id=\"srp-river-results\"]/ul/li[%o]//div[@class=\"s-item__info clearfix\"]//span[@role=\"heading\"]",i)));
            ExtendedWebElement item2 = findExtendedWebElement(
                    By.xpath(String.format("//*[@id=\"srp-river-results\"]/ul/li[%o]//div[@class=\"s-item__info clearfix\"]//span[@class=\"s-item__price\"]",i)));

            LOGGER.info(item.getText() +" "+item2.getText());
        }
    }

    public void printAllPrices(){

        for(ExtendedWebElement pricesX: prices){
           LOGGER.info(pricesX.getText());
        }

    }

    public void maxPrice(String s){
        max.type(s);
        button.click();
        pause(5);
    }


    public void printAllCategories() {
        for (ExtendedWebElement cl : categoryLinks) {
            cl.click();
            LOGGER.info(cl.getText());
        }
    }

}

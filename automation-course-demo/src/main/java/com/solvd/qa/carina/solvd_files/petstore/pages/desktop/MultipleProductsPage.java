package com.solvd.qa.carina.solvd_files.petstore.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.pages.common.MultipleProductsPageBase;
import com.solvd.qa.carina.solvd_files.petstore.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class MultipleProductsPage extends MultipleProductsPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//*[@id=\"CollectionSection\"]/div[2]/div/div/a/div[2]")
    private List<ExtendedWebElement> productList;
    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]")
    private Header header;

    public MultipleProductsPage(WebDriver driver){
        super(driver);
    }
    public List<ExtendedWebElement> getProductList(){
        return productList;
    }

    public void printAllProductTitle(){
        for(ExtendedWebElement product: productList){
            LOGGER.info(product.getText());
        }
    }
    public Header getHeader(){
        return header;
    }

    public ProductPage selectProduct(String product) {
        ExtendedWebElement expand;
        String element;

        LOGGER.info("selecting " + product  + " product >>>");
        for(int i = 1; i < productList.size(); i++){
            String currentProduct = productList.get(i-1).getText();

            if(product.equalsIgnoreCase(currentProduct)){
                element = String.format("//*[@id=\"CollectionSection\"]/div[2]/div[%o]/div/a",i);
                expand = findExtendedWebElement(By.xpath(element));
                waitUntil(ExpectedConditions.elementToBeClickable(expand.getElement()), 20000);
                expand.click();
//                    expand.pause(5);
                return new ProductPage(driver);
            }

        }
        LOGGER.error("Unable to open Product: " + product);
        return null;

    }


}

package com.solvd.qa.carina.solvd_files.petstore.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CartPageBase {

    @FindBy(xpath = "//*[@id=\"CartContainer\"]/div[1]/div")
    private List<ExtendedWebElement> listOfItems;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getListOfItems(){
        return listOfItems;

    }


}

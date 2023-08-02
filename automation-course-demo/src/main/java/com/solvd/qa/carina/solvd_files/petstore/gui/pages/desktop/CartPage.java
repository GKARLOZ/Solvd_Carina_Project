package com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.CartPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "")
    private List<ExtendedWebElement> listOfItems;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getListOfItems(){
        return listOfItems;

    }


}

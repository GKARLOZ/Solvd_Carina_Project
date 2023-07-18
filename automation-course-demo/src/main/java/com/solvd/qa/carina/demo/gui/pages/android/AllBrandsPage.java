package com.solvd.qa.carina.demo.gui.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.qa.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AllBrandsPageBase.class)
public class AllBrandsPage extends AllBrandsPageBase {

    @FindBy(xpath = "//div[@id='content']//h2[@class='section']")
    private ExtendedWebElement pageTitle;

    public AllBrandsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    @Override
    public BrandModelsPageBase selectBrand(String brandName){
        for (ExtendedWebElement brand: findExtendedWebElements(By.xpath("//div[@id='list-brands']//li/a"))){
            if (brand.getText().equalsIgnoreCase(brandName)){
                brand.click();
                return initPage(driver, BrandModelsPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open brand page: " + brandName);
    }

}

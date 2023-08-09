package com.solvd.qa.carina.solvd_test;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.HomePageBase;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.ProductPageBase;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.ShopByCategoryPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EbayMobileTest implements IAbstractTest, IMobileUtils {

    @Test(dataProvider = "DP1")
    public void TestA(String searchProduct, double idealPrice){

        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.closePopUp().clickIfPresent();
//        homePage.waitUntil(ExpectedConditions.visibilityOf(homePage.getHomeButton().getElement()), 2000);
        Assert.assertTrue(homePage.getLogo().isElementPresent(),"Not in HomePage");
        ShopByCategoryPageBase catePate = homePage.search(searchProduct);
        ProductPageBase productPage = catePate.swipeUntil(idealPrice);
        String productBidPriceString = productPage.getBidPrice().getText().replaceAll("\\$|\\,","");
        Double productBidPrice = Double.parseDouble(productBidPriceString);
        Assert.assertTrue(productBidPrice < idealPrice, "Product price over the iealPrice.");



    }

    @DataProvider(name ="DP1")
    public Object[][]dataproviderForSearch(){

        return new Object[][]{
                {"Jeep Wrangler",2500.00},
                {"Ford Raptor",10000.00}
        };

    }




}

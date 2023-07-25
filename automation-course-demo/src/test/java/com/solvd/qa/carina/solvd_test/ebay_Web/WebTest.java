package com.solvd.qa.carina.solvd_test.ebay_Web;

import com.solvd.qa.carina.solvd_files.ebay.common.GSMPageBase;
import com.solvd.qa.carina.solvd_files.ebay.common.HomePageBase;
import com.solvd.qa.carina.solvd_files.ebay.common.ShopByCategoryPageBase;
import com.solvd.qa.carina.solvd_files.ebay.desktop.GSMPage;
import com.solvd.qa.carina.solvd_files.ebay.desktop.ShopByCategoryPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    public void testEbayAllCarTrucks(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.selectFromMenu("Motors")
                .selectCategory("Car & Truck Parts")
                .selectInnerCategory("See all in Car & Truck Parts")
                .printAllCategories();

    }
    @Test
    public void testEbayCompressorPrices() {
        String url = "https://www.ebay.com/b/BMW-Car-and-Truck-AC-Compressors/33543/bn_580245";

        ShopByCategoryPageBase catePage = new ShopByCategoryPage(getDriver(),url);
        catePage.open();
        Assert.assertTrue(catePage.isPageOpened(), "Home page is not opened");

        catePage.printAllPrices();

//        ShopByCategoryPageBase motorsPage =  homePage.selectFromMenu("Motors");
//        ShopByCategoryPageBase finalPage = motorsPage.selectCategory("Car & Truck Parts")
//                .selectInnerCategory("See all in Car & Truck Parts")
//                .selectCategory("Air Conditioning & Heating")
//                .selectInnerCategory("See all in Air Conditioning & Heating")
//                .selectBrand("BMW");

    }
    @Test
    public void testEbayMobilePhones() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        ShopByCategoryPageBase ListOfPhonesPage = homePage.searchItem("mobile phones");
        ListOfPhonesPage.maxPrice("300").getItemAndPrice();
    }


    @Test
    public void testGSMDailyHits(){
        String url = "https://www.gsmarena.com";
        GSMPageBase homePage = new GSMPage(getDriver(), url);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getDailyHits("Samsung");

    }

    }

package com.solvd.qa.carina.solvd_test;

import com.solvd.qa.carina.solvd_files.ebay.gui.common.GSMPageBase;
import com.solvd.qa.carina.solvd_files.ebay.gui.common.HomePageBase;
import com.solvd.qa.carina.solvd_files.ebay.gui.common.ShopByCategoryPageBase;
import com.solvd.qa.carina.solvd_files.ebay.gui.desktop.GSMPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayWebTest implements IAbstractTest {

    @Test
    public void testEbayAllCarTrucks(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        ShopByCategoryPageBase categoryPage = homePage.selectFromMenu("Motors");
        categoryPage.selectCategory("Car & Truck Parts");
        categoryPage.selectInnerCategory("See all in Car & Truck Parts");
        Assert.assertTrue(categoryPage.getCategoryLinks().get(0).getText().equals("Accessory Belts"), "Wrong categories");
        categoryPage.printAllCategories();

    }
    @Test
    public void testEbayCompressorPrices() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        ShopByCategoryPageBase categoryPage = homePage.selectFromMenu("Motors");
        categoryPage.selectCategory("Car & Truck Parts");
        categoryPage.selectInnerCategory("See all in Car & Truck Parts");
        categoryPage.selectCategory("Air Conditioning & Heating");
        categoryPage.selectInnerCategory("A/C Compressors & Clutches");
        categoryPage.selectBrand("BMW");

        Assert.assertTrue(categoryPage.getPrices().size() > 0, "No prices found");
        categoryPage.printAllPrices();

    }
    @Test
    public void testEbayMobilePhones() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        ShopByCategoryPageBase ListOfPhonesPage = homePage.searchItem("mobile phones");
        ListOfPhonesPage.maxPrice("300");
        ListOfPhonesPage.getItemAndPrice();
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

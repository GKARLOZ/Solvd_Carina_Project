package com.solvd.qa.carina.solvd_test.PetStoreWebTests;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.MultipleProductsPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public interface IPick extends IAbstractTest {

    default ProductPageBase pickProduct() {


        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().openMenu();
        homePage.getHeader().expandCategory("Bird");
        MultipleProductsPageBase multiplePPage =  homePage.getHeader().clickInnerCategory("Treats");
        String itemPicked = "LAFEBER'S® TROPICAL FRUIT NUTRI-BERRIES FOR PARAKEET, COCKATIELS & LOVEBIRDS 10 OZ\nPETSTORE\n$20.75";
        Assert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(itemPicked), "First product in Treats for Birds does not match.");
        ProductPageBase productPage = multiplePPage.selectProduct(itemPicked);
        return productPage;
    }

    default MultipleProductsPageBase pickCategory(){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().openMenu();
        homePage.getHeader().expandCategory("Bird");
        MultipleProductsPageBase multiplePPage =  homePage.getHeader().clickInnerCategory("Treats");
        SoftAssert softAssert = new SoftAssert();
        String firstProduct = "LAFEBER'S® TROPICAL FRUIT NUTRI-BERRIES FOR PARAKEET, COCKATIELS & LOVEBIRDS 10 OZ\nPETSTORE\n$20.75";
        softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(firstProduct), "First product in Treats for Birds does not match.");

        return multiplePPage;
    }



}

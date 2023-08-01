package com.solvd.qa.carina.solvd_test.mobile;



import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.*;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common.PetHomePageBase;

import com.zebrunner.carina.core.IAbstractTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MobileTest implements IPick,IOpenAccount,IAbstractTest {


    @Test(dataProvider ="DP1")
    public void TestCartItems(String expandCate, String category, String item ){

        ProductPage productPage = pickProduct();
        productPage.clickAddToCart();
        productPage.getHeader().closeCart();

        productPage.getHeader().openMenu();
        productPage.getHeader().expandCategory(expandCate);
        MultipleProductsPage multiplePPage =  productPage.getHeader().clickInnerCategory(category);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(item), "First product in Treats for Birds does not match.");
        productPage = multiplePPage.selectProduct(item);

        softAssert.assertTrue(productPage.getHeader().getItemsInCart().size() == 1,"Wrong amount of items in Cart");
        softAssert.assertAll();

    }

    @Test(dataProvider = "DP1")
    public void TestListOfProducts(String expand, String category, String firstProduct){
        MultipleProductsPage multiplePPage = pickCategory();

        SoftAssert softAssert = new SoftAssert();
        multiplePPage.getHeader().openMenu();
        multiplePPage.getHeader().expandCategory(expand);
        multiplePPage.getHeader().clickInnerCategory(category);
        softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(firstProduct), "First product in "+category+" category does not match.");

        softAssert.assertAll();

    }
    @Test(dataProvider = "DP2")
    public void TestSearchResults(String item){

        PetHomePageBase homePage = initPage(getDriver(), PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SoftAssert softAssert = new SoftAssert();
        homePage.getHeader().searchItem(item);
        ProductPage productPage = homePage.getHeader().selectFromSearchResults(1);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains(item.toUpperCase()), "Item does not contain the input");

        softAssert.assertAll();

    }

    @Test(dataProvider = "DP3")
    public void testUserFlow(String email, String password,String cate, String item){

        LogInPage logInPage = openLogInPage();
        logInPage.putEmailTextField(email);
        logInPage.putPasswordTextField(password);
        AccountPage accountPage = logInPage.clickSignIn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(accountPage.getAccountOwner().getText().equalsIgnoreCase("JUANITO OTINAUJ"),"Account name does not match");

        accountPage.getHeader().openMenu();
        MultipleProductsPage multiplePPage = accountPage.getHeader().clickCategory(cate);
        ProductPage productPage = multiplePPage.selectProduct(item);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains("EXERCISE BALL"), "Item does not match selected");

        softAssert.assertAll();

    }

    @Test
    public void testCreateAccount(){

        CreateAccountPage createPage = openCreatePage();

        String random = RandomStringUtils.randomAlphanumeric(10);
        String firstName = "Charles";
        String lastName = "Xaiver";
        createPage.putFirstNameTextField(firstName);
        createPage.putLastNameTextField(lastName);
        createPage.putEmailTextField(random+"@gmail.com");
        createPage.putPasswordTextField(random);
        PetHomePage homePage = new PetHomePage(getDriver());
        homePage.getHeader().openMenu();
        AccountPage accountPage = homePage.getHeader().openAccountPage();
        String fullName = firstName +" "+lastName;
        Assert.assertTrue(accountPage.getAccountOwner().getText().equalsIgnoreCase(fullName),"Account name does not match");

    }

    @DataProvider(name = "DP1")
    public Object[][]dataproviderPickingProducts(){

        return new Object[][]{
                {"Dog","Toys","JOLLY PETS® PUSH-N-PLAY™ DOG TOYS BLUE COLOR X-LARGE 14 INCH\nPETSTORE\n$64.97"},
                {"Cat","Toys","DUCKY WORLD YEOWWW!® RAINBOW CATNIP TOYS 6 INCH\nPETSTORE\n$19.39"},
                {"Reptile & Amphibian","Lighting","ZILLA® MINI HALOGEN BULB 25 WATT NIGHT RED COLOR 2.5 X 0.75 X 4 INCH\nPETSTORE\n$23.14"}

        };

    }

    @DataProvider(name = "DP2")
    public Object[][]dataproviderForSearch(){

        return new Object[][]{
                {"JOLLY PETS"},
                {"Dog Toys"},
                {"Cat Toys"}

        };

    }

    @DataProvider(name ="DP3")
    public Object[][]dataproviderForUserFlow(){

        return new Object[][]{
                {"juanito_otinauj@gmail.com","12345!@#$","Dog","EXERCISE BALL FOR HAMSTERS AND SMALL PETS\nDISCOUNT PET SUPPLY\nRegular price\n$5.99\nSale price\n$3.49 Save $2.50"}
        };

    }



}

package com.solvd.qa.carina.solvd_test;

import com.solvd.qa.carina.solvd_files.petstore.pages.common.AccountPageBase;
import com.solvd.qa.carina.solvd_files.petstore.pages.common.MultipleProductsPageBase;
import com.solvd.qa.carina.solvd_files.petstore.pages.common.PetHomePageBase;
import com.solvd.qa.carina.solvd_files.petstore.pages.desktop.*;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.UUID;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class WebTest implements IAbstractTest {

    @Test
    public void TestCartItems(){
        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().openMenu();
        homePage.getHeader().expandCategory("Bird");
        MultipleProductsPageBase multiplePPage =  homePage.getHeader().clickInnerCategory("Treats");
        SoftAssert softAssert = new SoftAssert();
        String itemPicked = "LAFEBER'S® TROPICAL FRUIT NUTRI-BERRIES FOR PARAKEET, COCKATIELS & LOVEBIRDS 10 OZ\nPETSTORE\n$20.75";
        softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(itemPicked), "First product in Treats for Birds does not match.");
        ProductPage productPage = multiplePPage.selectProduct(itemPicked);
        productPage.clickAddToCart();
        productPage.getHeader().closeCart();

        productPage.getHeader().openMenu();
        productPage.getHeader().expandCategory("Dog");
        multiplePPage = productPage.getHeader().clickInnerCategory("Toys");
        itemPicked = "OUTWARD HOUND® STUFFING FREE LIL' SQUEAK MINI MONKEY DOG TOYS\nPETSTORE\n$19.77";
        softAssert.assertTrue(multiplePPage.getProductList().get(1).getText().equals(itemPicked), "Second item for Dogs does not match.");
        productPage = multiplePPage.selectProduct(itemPicked);
        productPage.clickAddToCart();

        softAssert.assertTrue(productPage.getHeader().getItemsInCart().size() == 2,"Wrong amount of items in Cart");
        softAssert.assertAll();

    }
    @Test
     public void TestListOfProducts(){
         PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
         homePage.open();
         Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

         homePage.getHeader().openMenu();
         homePage.getHeader().expandCategory("Bird");
         MultipleProductsPageBase multiplePPage =  homePage.getHeader().clickInnerCategory("Treats");
         SoftAssert softAssert = new SoftAssert();
         String firstProduct = "LAFEBER'S® TROPICAL FRUIT NUTRI-BERRIES FOR PARAKEET, COCKATIELS & LOVEBIRDS 10 OZ\nPETSTORE\n$20.75";
         softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(firstProduct), "First product in Treats for Birds does not match.");

         multiplePPage.getHeader().openMenu();
         multiplePPage.getHeader().clickCategory("Dog");
         firstProduct = "EXERCISE BALL FOR HAMSTERS AND SMALL PETS\nDISCOUNT PET SUPPLY\nRegular price\n$5.99\nSale price\n$3.49 Save $2.50";
         softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(firstProduct), "First product in Dogs category does not match.");

         multiplePPage.getHeader().openMenu();
         multiplePPage.getHeader().expandCategory("Reptile & Amphibian");
         multiplePPage.getHeader().clickInnerCategory("Lighting");
         firstProduct = "ZILLA® MINI HALOGEN BULB 25 WATT NIGHT RED COLOR 2.5 X 0.75 X 4 INCH\nPETSTORE\n$23.14";
         softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(firstProduct), "First product in Lighting for Reptiles does not match.");

         softAssert.assertAll();

     }
    @Test
    public void testCreateAccount(){
        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LogInPage logInPage = homePage.getHeader().openLogin();
        CreateAccountPage createPage = logInPage.clickCreateAccount();

        String random = UUID.randomUUID().toString();
        String firstName = "Charles";
        String lastName = "Xaiver";
        createPage.putFirstNameTextField(firstName);
        createPage.putLastNameTextField(lastName);
        createPage.putEmailTextField(random+"@gmail.com");
        createPage.putPasswordTextField(random);

        homePage = createPage.clickCreateButton();
        AccountPage accountPage = homePage.getHeader().openAccountPage();
        String fullName = firstName +" "+lastName;
        Assert.assertTrue(accountPage.getAccountOwner().getText().equalsIgnoreCase(fullName),"Account name does not match");

    }

    @Test
    public void TestSearchResults(){
        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SoftAssert softAssert = new SoftAssert();
        String item = "JOLLY PETS";
        homePage.getHeader().searchItem(item);
        ProductPage productPage = homePage.getHeader().selectFromSearchResults(1);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains(item), "Item does not contain the input");

        item = "DOG TOYS";
        productPage.getHeader().searchItem(item);
        productPage.getHeader().selectFromSearchResults(2);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains(item), "Item does not contain the input");

        item = "CAT TOYS";
        productPage.getHeader().searchItem(item);
        productPage.getHeader().selectFromSearchResults(2);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains(item), "Item does not contain the input");

        softAssert.assertAll();

    }
    @Test
    public void testUserFlow(){
        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LogInPage logInPage = homePage.getHeader().openLogin();

        String email = "juanito_otinauj@gmail.com";
        String password = "12345!@#$";

        logInPage.putEmailTextField(email);
        logInPage.putPasswordTextField(password);
        AccountPage accountPage = logInPage.clickSignIn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(accountPage.getAccountOwner().getText().equalsIgnoreCase("JUANITO OTINAUJ"),"Account name does not match");

        accountPage.getHeader().openMenu();
        MultipleProductsPage multiplePPage = accountPage.getHeader().clickCategory("Dog");
        String product = "EXERCISE BALL FOR HAMSTERS AND SMALL PETS\nDISCOUNT PET SUPPLY\nRegular price\n$5.99\nSale price\n$3.49 Save $2.50";
        ProductPage productPage = multiplePPage.selectProduct(product);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains("EXERCISE BALL"), "Item does not match selected");

        softAssert.assertAll();

    }

}

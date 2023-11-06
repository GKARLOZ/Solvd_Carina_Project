package com.solvd.qa.carina.solvd_test.PetStoreWebTests;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.UUID;

public class DesktopChromeWebTest implements IPick, IOpenAccount,IAbstractTest {

    @Test(dataProvider ="DP1")
    public void TestCartItems(String expandCate, String category, String item ){

        PetHomePageBase homePage = initPage(getDriver("chrome", new ChromeCapabilities().getCapability("Chrome Test")),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().openMenu();
        homePage.getHeader().expandCategory("Bird");
        MultipleProductsPageBase multiplePPage =  homePage.getHeader().clickInnerCategory("Treats");
        String itemPicked = "LAFEBER'S® TROPICAL FRUIT NUTRI-BERRIES FOR PARAKEET, COCKATIELS & LOVEBIRDS 10 OZ\nPETSTORE\n$20.75";
        Assert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(itemPicked), "First product in Treats for Birds does not match.");
        ProductPageBase productPage = multiplePPage.selectProduct(itemPicked);



//        ProductPageBase productPage = pickProduct();
        productPage.clickAddToCart();
        productPage.getHeader().closeCart();

        productPage.getHeader().openMenu();
        productPage.getHeader().expandCategory(expandCate);
        multiplePPage = productPage.getHeader().clickInnerCategory(category);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(item), "item does not match.");
        productPage = multiplePPage.selectProduct(item);
        productPage.clickAddToCart();
        productPage.getHeader().closeCart();

        softAssert.assertTrue(productPage.getHeader().getItemsInCart().size() == 2,"Wrong amount of items in Cart");
        softAssert.assertAll();

    }

    //@Test(dataProvider = "DP1")
    public void TestListOfProducts(String expand, String category, String firstProduct){
        MultipleProductsPageBase multiplePPage = pickCategory();

        SoftAssert softAssert = new SoftAssert();
        multiplePPage.getHeader().openMenu();
        multiplePPage.getHeader().expandCategory(expand);
        multiplePPage.getHeader().clickInnerCategory(category);
        softAssert.assertTrue(multiplePPage.getProductList().get(0).getText().equals(firstProduct), "First product in "+category+" category does not match.");

        softAssert.assertAll();

    }
    //@Test(dataProvider = "DP2")
    public void TestSearchResults(String item){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SoftAssert softAssert = new SoftAssert();
        homePage.getHeader().searchItem(item);
        ProductPageBase productPage = homePage.getHeader().selectFromSearchResults(1);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains(item.toUpperCase()), "Item does not contain the input");

        softAssert.assertAll();

    }

    //@Test(dataProvider = "DP3")
    public void testUserFlow(String email, String password){

        LogInPageBase logInPage = openLogInPage();

        logInPage.putEmailTextField(email);
        logInPage.putPasswordTextField(password);
//        pause(10);
        AccountPageBase accountPage = logInPage.clickSignIn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(accountPage.getAccountOwner().getText().equalsIgnoreCase("JUANITO OTINAUJ"),"Account name does not match");

        accountPage.getHeader().openMenu();
        MultipleProductsPageBase multiplePPage = accountPage.getHeader().clickCategory("Dog");
        String product = "EXERCISE BALL FOR HAMSTERS AND SMALL PETS\nDISCOUNT PET SUPPLY\nRegular price\n$5.99\nSale price\n$3.49 Save $2.50";
        ProductPageBase productPage = multiplePPage.selectProduct(product);
        softAssert.assertTrue(productPage.getProductTitle().getText().contains("EXERCISE BALL"), "Item does not match selected");

        softAssert.assertAll();

    }

    //@Test
    public void testCreateAccount(){

        CreateAccountPageBase createPage = openCreatePage();

        String random = UUID.randomUUID().toString();
        String firstName = "Charles";
        String lastName = "Xaiver";
        createPage.putFirstNameTextField(firstName);
        createPage.putLastNameTextField(lastName);
        createPage.putEmailTextField(random+"@gmail.com");
        createPage.putPasswordTextField(random);

//        pause(7);
        PetHomePageBase homePage = createPage.clickCreateButton();
        AccountPageBase accountPage = homePage.getHeader().openAccountPage();
        String fullName = firstName +" "+lastName;
        Assert.assertTrue(accountPage.getAccountOwner().getText().equalsIgnoreCase(fullName),"Account name does not match");

    }

    @DataProvider(name = "DP1")
    public Object[][]dataproviderPickingProducts(){

        return new Object[][]{
//                {"Dog","Toys","JOLLY PETS® PUSH-N-PLAY™ DOG TOYS BLUE COLOR X-LARGE 14 INCH\nPETSTORE\n$64.97"},
//                {"Cat","Toys","DUCKY WORLD YEOWWW!® RAINBOW CATNIP TOYS 6 INCH\nPETSTORE\n$19.39"},
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
    public Object[][]dataproviderForLogin(){

        return new Object[][]{
                {"juanito_otinauj@gmail.com","12345!@#$"}
        };

    }

}

package com.solvd.qa.carina.solvd_test.PetStoreWebTests;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.CreateAccountPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.LogInPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;

public interface IOpenAccount extends IAbstractTest {

    default LogInPageBase openLogInPage(){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getHeader().openMenu();
        return homePage.getHeader().openLogin();

    }

    default CreateAccountPageBase openCreatePage(){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().openMenu();
        LogInPageBase logInPage = homePage.getHeader().openLogin();
        return logInPage.clickCreateAccount();

    }
}

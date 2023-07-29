package com.solvd.qa.carina.solvd_test;

import com.solvd.qa.carina.solvd_files.petstore.pages.common.PetHomePageBase;
import com.solvd.qa.carina.solvd_files.petstore.pages.desktop.CreateAccountPage;
import com.solvd.qa.carina.solvd_files.petstore.pages.desktop.LogInPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;

public interface IOpenAccount extends IAbstractTest {

    default LogInPage openLogInPage(){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        return homePage.getHeader().openLogin();

    }

    default CreateAccountPage openCreatePage(){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LogInPage logInPage = homePage.getHeader().openLogin();
        return logInPage.clickCreateAccount();

    }
}

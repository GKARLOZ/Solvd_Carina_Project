package com.solvd.qa.carina.solvd_test.mobile;

import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.LogInPage;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common.PetHomePageBase;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.CreateAccountPage;



import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;

public interface IOpenAccount extends IAbstractTest {

    default LogInPage openLogInPage(){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().openMenu();
        return homePage.getHeader().openLogin();

    }

    default CreateAccountPage openCreatePage(){

        PetHomePageBase homePage = initPage(getDriver(),PetHomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().openMenu();
        LogInPage logInPage = homePage.getHeader().openLogin();
        return logInPage.clickCreateAccount();

    }
}

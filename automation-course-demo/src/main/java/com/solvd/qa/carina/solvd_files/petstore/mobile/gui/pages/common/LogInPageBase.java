package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common;


import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.AccountPage;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android.CreateAccountPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LogInPageBase extends AbstractPage {

    public LogInPageBase(WebDriver driver) {
        super(driver);

    }
    public abstract void putEmailTextField(String email);
    public abstract void putPasswordTextField(String password);
    public abstract AccountPage clickSignIn();
    public abstract CreateAccountPage clickCreateAccount();
    public abstract ExtendedWebElement getTitleOfPage();

}

package com.solvd.qa.carina.solvd_files.petstore.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CreateAccountPageBase extends AbstractPage {


    public CreateAccountPageBase(WebDriver driver) {
        super(driver);

    }

    public abstract void putFirstNameTextField(String name);
    public abstract void putLastNameTextField(String last);
    public abstract void putEmailTextField(String email);
    public abstract void putPasswordTextField(String password);
    public abstract PetHomePageBase clickCreateButton();

}

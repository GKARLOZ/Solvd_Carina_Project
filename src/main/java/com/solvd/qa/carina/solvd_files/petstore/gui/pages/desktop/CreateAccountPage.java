package com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.CreateAccountPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CreateAccountPageBase.class)
public class CreateAccountPage extends CreateAccountPageBase {

    @FindBy(xpath = "//*[@id=\"FirstName\"]")
    private ExtendedWebElement firstNameTextField;
    @FindBy(xpath = "//*[@id=\"LastName\"]")
    private ExtendedWebElement lastNameTextField;
    @FindBy(xpath = "//*[@id=\"Email\"]")
    private ExtendedWebElement emailTextField;
    @FindBy(xpath = "//*[@id=\"CreatePassword\"]")
    private ExtendedWebElement passwordTextField;
    @FindBy(xpath = "//*[@value=\"Create\"]")
    private ExtendedWebElement createButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void putFirstNameTextField(String name) {
        firstNameTextField.type(name);
    }
    @Override
    public void putLastNameTextField(String last) {
        lastNameTextField.type(last);
    }
    @Override
    public void putEmailTextField(String email) {
        emailTextField.type(email);
    }
    @Override
    public void putPasswordTextField(String password) {
        passwordTextField.type(password);
    }
    @Override
    public PetHomePageBase clickCreateButton(){
        createButton.click();
        return new PetHomePage(driver);

    }


}

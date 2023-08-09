package com.solvd.qa.carina.solvd_files.petstore.gui.pages.android;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.CreateAccountPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateAccountPageBase.class)
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
    public PetHomePage clickCreateButton(){
        createButton.click();
        return new PetHomePage(driver);

    }


}

package com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.CreateAccountPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends CreateAccountPageBase {

    @FindBy(xpath = "//*[@id=\"FirstName\"]")
    private ExtendedWebElement firstNameTextField;
    @FindBy(xpath = "//*[@id=\"LastName\"]")
    private ExtendedWebElement lastNameTextField;
    @FindBy(xpath = "//*[@id=\"Email\"]")
    private ExtendedWebElement emailTextField;
    @FindBy(xpath = "//*[@id=\"CreatePassword\"]")
    private ExtendedWebElement passwordTextField;
    @FindBy(xpath = "//*[@id=\"create_customer\"]/p/input")
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
        createButton.click(50000);
        pause(5);
        return new PetHomePage(driver);

    }


}

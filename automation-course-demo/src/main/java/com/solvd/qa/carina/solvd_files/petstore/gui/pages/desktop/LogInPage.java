package com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.AccountPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.CreateAccountPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.LogInPageBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {

    @FindBy(xpath = "//*[@id=\"CustomerEmail\"]")
    private ExtendedWebElement emailTextField;
    @FindBy(xpath ="//*[@id=\"CustomerPassword\"]" )
    private ExtendedWebElement passwordTextField;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/p[1]/button")
    private ExtendedWebElement signInButton;
    @FindBy(xpath = "//*[@id=\"customer_register_link\"]")
    private ExtendedWebElement createAccount;
    @FindBy(xpath = "//*[@id=\"MainContent\"]//h1[contains(@class,'section-header__title')]")
    private ExtendedWebElement titleOfPage;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void putEmailTextField(String email){
        emailTextField.type(email);
    }

    public void putPasswordTextField(String password){
        passwordTextField.type(password);
    }

    public AccountPageBase clickSignIn(){
        signInButton.click();
        return new AccountPage(driver);
    }

    public CreateAccountPageBase clickCreateAccount(){
        createAccount.click();
        return new CreateAccountPage(driver);
    }

    public ExtendedWebElement getTitleOfPage(){
        return titleOfPage;
    }

}

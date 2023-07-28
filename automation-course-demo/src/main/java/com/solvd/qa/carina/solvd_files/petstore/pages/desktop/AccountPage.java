package com.solvd.qa.carina.solvd_files.petstore.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.pages.common.AccountPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AccountPageBase {

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div/div[2]/p[1]")
    private ExtendedWebElement accountOwner;
    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div/div/header/h1")
    private ExtendedWebElement titleOfPage;
    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]")
    private Header header;

    public AccountPage(WebDriver driver){
        super(driver);
    }
    public ExtendedWebElement getAccountOwner(){
        return accountOwner;
    }
    public ExtendedWebElement getTitleOfPage(){
        return titleOfPage;
    }
    public Header getHeader(){
        return header;
    }



}

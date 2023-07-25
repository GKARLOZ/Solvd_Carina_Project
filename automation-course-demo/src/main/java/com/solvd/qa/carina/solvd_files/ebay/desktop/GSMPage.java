package com.solvd.qa.carina.solvd_files.ebay.desktop;

import com.solvd.qa.carina.solvd_files.ebay.common.GSMPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GSMPageBase.class)
public class GSMPage extends GSMPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//*[@id=\"body\"]/aside/div[5]/table/tbody//th")
    private ExtendedWebElement dailyHits;
    public GSMPage(WebDriver driver) {
        super(driver);
    }

    public GSMPage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
        setUiLoadedMarker(dailyHits);
    }

    public void getDailyHits(String s){

        for(int i=2; i < 10; i++){

            ExtendedWebElement item = findExtendedWebElement(
                    By.xpath(String.format("//*[@id=\"body\"]/aside/div[5]/table/tbody/tr[%o]//th",i)));

            ExtendedWebElement item2 = findExtendedWebElement(
                    By.xpath(String.format("//*[@id=\"body\"]/aside/div[5]/table/tbody/tr[%o]//td[2]",i)));

            if(item.getText().contains(s)){
                LOGGER.info(item.getText() +" "+item2.getText());
            }
        }
    }




}

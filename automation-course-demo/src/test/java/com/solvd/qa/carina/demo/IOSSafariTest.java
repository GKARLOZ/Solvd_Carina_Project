package com.solvd.qa.carina.demo;

import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.solvd.qa.carina.demo.mobile.gui.pages.ios.SaucePage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class IOSSafariTest implements IAbstractTest, IMobileUtils {

    @Test
    public void safariTest() {
        SaucePage saucePage = new SaucePage(getDriver());
        saucePage.openURL("http://saucelabs.com/test/guinea-pig");
        
        saucePage.verifyElementText();
        saucePage.sendComment();
    }

}

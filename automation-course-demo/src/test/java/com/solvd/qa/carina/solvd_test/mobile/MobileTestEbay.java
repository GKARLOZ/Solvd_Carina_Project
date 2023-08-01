package com.solvd.qa.carina.solvd_test.mobile;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.android.ShopByCategoryPage;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class MobileTestEbay implements IAbstractTest {

    @Test
    public void TestA(){

        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.closePopUp().clickIfPresent();
        ShopByCategoryPage catePate = homePage.search("Cars");

    }


}

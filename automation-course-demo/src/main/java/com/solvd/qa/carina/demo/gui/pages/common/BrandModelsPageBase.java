package com.solvd.qa.carina.demo.gui.pages.common;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.solvd.qa.carina.demo.gui.components.ModelItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class BrandModelsPageBase extends AbstractPage {

    public BrandModelsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ModelInfoPageBase selectModel(String modelName);

    public abstract List<ModelItem> getModels();

}

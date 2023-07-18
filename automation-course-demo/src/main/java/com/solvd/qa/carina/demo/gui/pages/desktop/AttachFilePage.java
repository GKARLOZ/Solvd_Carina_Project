package com.solvd.qa.carina.demo.gui.pages.desktop;

import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class AttachFilePage extends AbstractPage {

    @FindBy(id = "file-upload")
    private ExtendedWebElement fileUploadingArea;

    @FindBy(id = "file-submit")
    private ExtendedWebElement submitButton;

    @FindBy(id = "content")
    private ExtendedWebElement content;

    public AttachFilePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(fileUploadingArea);
        setPageAbsoluteURL("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(Path pathToFile) {
        this.fileUploadingArea.attachFile(pathToFile.toAbsolutePath().toString());
    }

    public void submit() {
        this.submitButton.click();
    }

    public boolean isFileUploaded() {
        return this.content.isElementWithTextPresent("File Uploaded!");
    }

}

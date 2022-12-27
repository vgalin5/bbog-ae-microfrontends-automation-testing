package com.co.bancodebogota.Microfrontends;

import com.co.bancodebogota.wrapper.SeleniumWrapper;
import com.co.bancodebogota.wrapper.ShadowRoot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MicroFrontendDocuments extends SeleniumWrapper {
    By root1 = By.tagName("cust-doc-bdb-ml-accept-docs");
    By root2 = By.tagName("cust-doc-bdb-at-check-button");
    By consultLetterInstructionPay = By.id("#bdb-at-check-button");
    By confirmPage = By.cssSelector("div[class='title']");

    public MicroFrontendDocuments(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
    public void clienteSinFatcayDebitoAutomatico() {
        ShadowRoot shadowDom = new ShadowRoot(driver);
        if (isDisplayed(confirmPage)) {
            shadowDom.shadowClick2(root1, root2, consultLetterInstructionPay);
        } else {
            //cambiar por log
            System.out.println("fallo");
        }
    }
}

package com.co.bancodebogota.Microfrontends;

import com.co.bancodebogota.wrapper.SeleniumWrapper;
import com.co.bancodebogota.wrapper.ShadowRoot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MicroFrontendAccounts extends SeleniumWrapper  {
    ShadowRoot shadowDom;
    By root1 = By.xpath("//cont-acnt-bdb-ml-multi-selector[@class='hydrated']");
    By root2 = By.cssSelector("#radio__0");
    By confirmPage = By.cssSelector("div.pg-account-container__title");
    By btnContinue = By.xpath("//button[contains(text(),'Continuar ›')]");
    public MicroFrontendAccounts(WebDriver driver) {
        super(driver);
        this.shadowDom = new ShadowRoot(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
    public void selectAccount() throws InterruptedException {
        Thread.sleep(10000);
        if(isDisplayed(confirmPage)){
            shadowDom.shadowClick1(root1,root2);
            Thread.sleep(10000);
            click(btnContinue);
        }else{
            //cambiar a log
            System.out.println("No paso");
        }
    }
}

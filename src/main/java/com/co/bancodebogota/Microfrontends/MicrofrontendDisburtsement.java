package com.co.bancodebogota.Microfrontends;

import com.co.bancodebogota.wrapper.SeleniumWrapper;
import com.co.bancodebogota.wrapper.ShadowRoot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MicrofrontendDisburtsement extends SeleniumWrapper {
    ShadowRoot shadowDom;
    By confirmPage1 = By.xpath("//div[contains(text(),'Revisa las condiciones del crédito y desembolsa el dinero')]");
    By confirmPage2 = By.xpath("//div[contains(text(),'¿Quieres proteger las cuotas de tu crédito?')]");
    By root1 = By.xpath("//cont-dis-bdb-ml-card-price[@id='insurance-Card']");
    By root2 = By.cssSelector("#radio__0");
    By root3 = By.cssSelector("#check_0 > div");
    By root4 = By.xpath("//cont-dis-bdb-ml-card-price[@id='without-insurance-Card']");
    By root5 = By.cssSelector("#bdb-at-check-button");
    By scrol1 = By.xpath("//div[contains(text(),'todos los efectos mi firma física y reconozco que tales actuaciones')]");
    By btnDisburtsement1 = By.xpath("//button[contains(text(),'Desembolsar ›')]");
    By btnDisburtsement2 = By.xpath("//button[contains(text(),'Desembolsar ›')]");
    public MicrofrontendDisburtsement(WebDriver driver) {
        super(driver);
        shadowDom = new ShadowRoot(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
        public void disburtsementUninsured() throws InterruptedException {

            Thread.sleep(10000);
            if (isDisplayed(confirmPage1)) {
                click(btnDisburtsement1);
                Thread.sleep(4000);
            } else {
                //cambiar por log
                System.out.println("log  de error");
            }
        }
        public void disburtsementWhitInsurance() throws InterruptedException {
            Thread.sleep(10000);
            if(isDisplayed(confirmPage2)) {
                shadowDom.shadowClick2(root1, root2, root3);
                Thread.sleep(2000);
                click(btnDisburtsement2);
                Thread.sleep(2000);
                scroll(scrol1,root5);
                Thread.sleep(2000);
                click(btnDisburtsement2);
            }else{
                //cambiar por log
                System.out.println("fallo");
            }
        }
        public void disburtsementWhitout() throws InterruptedException {
            Thread.sleep(10000);
            if(isDisplayed(confirmPage2)) {
                Thread.sleep(4000);
                shadowDom.shadowClick2(root4, root2, root3);
                Thread.sleep(4000);
                click(btnDisburtsement2);
                Thread.sleep(4000);
        }
    }
}


package com.co.bancodebogota.Microfrontends;
import com.co.bancodebogota.wrapper.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MicroFrontendCongrats extends SeleniumWrapper {
    By confPantCongrats = By.xpath("//div[contains(text(),'Cuenta de desembolso')]");
    By btnContinue = By.xpath("//button[@id='btn-getout']");

    public MicroFrontendCongrats(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
    public void congratsContinue() throws InterruptedException {
        if (isDisplayed(confPantCongrats)) {
            Thread.sleep(2000);
            click(btnContinue);
        } else {
            //cambiar por log
            System.out.println("fallo");
        }
    }
}

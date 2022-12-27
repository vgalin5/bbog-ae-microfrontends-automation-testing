package com.co.bancodebogota.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShadowRoot {
    public WebDriver driver;
    public ShadowRoot(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
    public void shadowClick1(By Ro1, By element){

        WebElement root1 = driver.findElement(Ro1);
        SearchContext shadowRoot1 = root1.getShadowRoot();
        shadowRoot1.findElement(element).click();
    }
    public void shadowClick2(By Ro1, By Ro2, By element){

        WebElement root1 = driver.findElement(Ro1);
        SearchContext shadowRoot1 = root1.getShadowRoot();
        WebElement root2 = shadowRoot1.findElement(Ro2);
        SearchContext shadowRoot2 = root2.getShadowRoot();
        shadowRoot2.findElement(element).click();
    }

}

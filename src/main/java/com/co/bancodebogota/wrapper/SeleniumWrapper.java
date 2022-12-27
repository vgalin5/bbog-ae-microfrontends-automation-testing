package com.co.bancodebogota.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

public class SeleniumWrapper {

    public WebDriver driver;
    String textLocator = "";

    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){

        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){

        return driver.findElements(locator);
    }

    public String getText(WebElement element){

        return element.getText();
    }

    public String getText(By locator){

        return driver.findElement(locator).getText();
    }

    public void insert(String inputText, By locator){

        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void pageAddress(String URL){
        driver.get(URL);
    }

    public void AssertText(WebElement element, String expectedMessage){
        textLocator = element.getText();
        Assert.assertEquals(textLocator, expectedMessage);
    }

    public void driverQuit(){
        driver.quit();
    }

    public void driverClose(){
        driver.close();
    }

    public void scroll(By locator, By locator2){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView();",locator);
        driver.findElement(locator2).getText();
    }

}

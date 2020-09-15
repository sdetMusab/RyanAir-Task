package com.ryanairAutomation.Pages;

import com.ryanairAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[.='Log in']")
    public WebElement login;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signin;

    public void Login(String str, String str2){
        email.sendKeys(str);
        password.sendKeys(str2, Keys.ENTER);

    }

}

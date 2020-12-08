package com.ryanairAutomation.Pages;

import com.ryanairAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    //hadi busefer degisiklikler olacak gibi

    @FindBy(xpath = "//label[.='One way']")
    public WebElement oneway;

    @FindBy(xpath = "//input[@placeholder='Departure']")
    public WebElement departure;

    @FindBy(xpath = "//span[.=' Spain ']")
    public WebElement countryName;

    @FindBy(xpath = "//input[@placeholder='Destination']")
    public WebElement destination;

    @FindBy(xpath = "//button[@aria-label='Search']")
    public WebElement search;

    @FindBy(xpath = "//span[.=' Ibiza ']/span")
    public WebElement airport;

    @FindBy(xpath = "//div[@data-ref='input-button__passengers']")
    public WebElement passenger;

    @FindBy(xpath = "//button[@class='subscriber-widget__close-button']")
    public WebElement popup;

    @FindBy(id = "glyphs.close")
    public WebElement popup2;

    public void setDepartDate(String date) {
        Driver.get().findElement(By.xpath("//div[@data-id='" + date + "']")).click();
    }

    @FindBy(xpath = "(//icon[@classlist='icon-24'])[6]/../../..")
    public WebElement Adult;

    @FindBy(xpath = "(//icon[@classlist='icon-24'])[10]/../../..")
    public WebElement Child;

    @FindBy(xpath = "(//div[@class='card-header b2'])[1]")
    public WebElement selectprice;

    @FindBy(xpath = "//span[.='Continue with Value fare']")
    public WebElement continueWithValue;

    @FindBy(xpath = "//button[@type='button'][@class='dropdown__toggle b2 dropdown__toggle--error']")
    public WebElement dropdown;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement title;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement name;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement surname;

    @FindBy(xpath = "//button[.=' Continue ']")
    public WebElement Continue;

    public void getTitle(String title) {
        List<WebElement> titles = Driver.get().findElements(By.cssSelector(".dropdown-item__label.b2"));
        switch (title.toLowerCase()) {
            case "mr":
                titles.get(0).click();
                break;
            case "mrs":
                titles.get(1).click();
                break;
            case "ms":
                titles.get(2).click();
                break;
        }

    }


}

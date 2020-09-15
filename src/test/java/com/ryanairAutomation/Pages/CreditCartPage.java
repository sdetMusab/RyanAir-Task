package com.ryanairAutomation.Pages;

import com.ryanairAutomation.utilities.BrowserUtils;
import com.ryanairAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCartPage {

    public CreditCartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@class='basket-tooltip__open-basket']")
    public WebElement viewbasket;

    @FindBy(css = ".basket-total-icon__state.ng-trigger.ng-trigger-tickAnimation")
    public WebElement basketicon;

    @FindBy(css = ".ry-button--full.ry-button--gradient-yellow")
    public WebElement checkout;

    @FindBy(xpath = "(//*[contains(text(),'+353')])[1]/../..")
    public WebElement countryCode;

    @FindBy(xpath = "(//*[contains(text(),'+93')])")
    public WebElement firstCountry;

    @FindBy(xpath = "(//div[*='South Sudan (+211)'])[2]")
    public WebElement Sudan;

    @FindBy(xpath = "(//div[*='Spain (+34)'])[2]")
    public WebElement Spain;

    @FindBy(xpath = "//*[text()='Phone number *']/../div/input")
    public WebElement phoneNumber;

    @FindBy(xpath = "//*[text()='Card number *']/../div/input")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    public WebElement ccv;

    @FindBy(xpath = "//ry-input-d[@data-ref='add-card-modal__account-name']//div/input")
    public WebElement cardHolderName;

    @FindBy(xpath = "//ry-input-d[@data-ref='add-card-modal__address-line-1']//div/input")
    public WebElement adressLine1;

    @FindBy(xpath = "//ry-input-d[@data-ref='add-card-modal__city']//div/input")
    public WebElement city;

    @FindBy(xpath = "//*[contains(text(),'Country *')]/../../input")
    public WebElement country;

    @FindBy(xpath = "//*[text()='Postcode/ZIP code *']/..//input")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id='insurance-opt-out']/../div[1]")
    public WebElement noinsurance;

    @FindBy(xpath = "//*[contains(text(),'Year')]/..")
    public WebElement yearDropDown;

    @FindBy(xpath = "//*[text()='Month']/..")
    public WebElement monthDropDown;

    @FindBy(xpath = "(//*[contains(text(),'Currency')][1]/..//button)[1]")
    public WebElement currency;

    @FindBy(xpath = "//*[contains(text(),'EUR')]")
    public WebElement currencyType;

    @FindBy(xpath = "//input[@id='termsAndConditions']/following-sibling::div[1]")
    public WebElement clickPayTick;

    @FindBy(xpath = "//*[contains(text(),' Pay now ')]")
    public WebElement payNow;

    @FindBy(xpath = "//ry-alert[@iconclass='icon-12']")
    public WebElement errorMessage;

    public void setYearandMonth(String date) throws InterruptedException {
        String[] Date = date.split("/");
        int years = Integer.parseInt(Date[1]);
        String exactYear = "20" + years;
        String exactMonth = Date[0] + "";

        WebElement monthElement = Driver.get().findElement(By.xpath("//*[text()='" + exactMonth + "']/.."));
        monthDropDown.click();
        BrowserUtils.waitForVisibility(monthElement,2);
        monthElement.click();

        WebElement yearElement = Driver.get().findElement(By.xpath("//*[text()='" + exactYear + "']"));
        yearDropDown.click();
        BrowserUtils.waitForVisibility(yearElement,2);
        BrowserUtils.clickWithJS(yearElement);
        Thread.sleep(2000);

    }


}

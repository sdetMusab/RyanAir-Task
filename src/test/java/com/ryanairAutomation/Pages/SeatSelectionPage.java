package com.ryanairAutomation.Pages;

import com.ryanairAutomation.utilities.BrowserUtils;
import com.ryanairAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeatSelectionPage {

    public SeatSelectionPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".ng-star-inserted.seatmap__seat.seatmap__seat--standard")
    public WebElement selectseat;

    @FindBy(xpath = "//button[.=' Continue ']")
    public WebElement Continue;

    @FindBy(xpath = "//label[@for='ry-radio-button--0']")
    public WebElement smallbag;

    @FindBy(xpath = "//button[@color='gradient-yellow']")
    public WebElement Continue2;

    public void SeatSelection(String seatnumber) {
        WebElement selectseatno =  Driver.get().findElement(By.xpath("(//button[@class='ng-star-inserted seatmap__seat seatmap__seat--standard'])["+seatnumber+"]"));
        try {
            selectseatno.click();
        } catch (Exception e) {
            System.out.println("Seat is already selected try another number");
        }

    }
}

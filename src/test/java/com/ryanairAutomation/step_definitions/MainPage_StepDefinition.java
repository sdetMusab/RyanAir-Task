package com.ryanairAutomation.step_definitions;

import com.ryanairAutomation.Pages.CreditCartPage;
import com.ryanairAutomation.Pages.LoginPage;
import com.ryanairAutomation.Pages.MainPage;
import com.ryanairAutomation.Pages.SeatSelectionPage;
import com.ryanairAutomation.utilities.BrowserUtils;
import com.ryanairAutomation.utilities.ConfigurationProperties;
import com.ryanairAutomation.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MainPage_StepDefinition {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    SeatSelectionPage seatSelectionPage = new SeatSelectionPage();
    CreditCartPage creditCartPage = new CreditCartPage();

    @Given("I enter valid credentials to login into Ryanair")
    public void i_enter_valid_credentials_to_login_into_Ryanair() {

        mainPage.popup2.click();
        mainPage.popup.click();
        loginPage.login.click();
        loginPage.Login(ConfigurationProperties.get("email"), ConfigurationProperties.get("password"));

    }

    @And("I make a booking from {string} to {string} on {string} for {string} adults and {string} child")
    public void i_make_a_booking_from_to_on_for_adults_and_child(String departure, String arrival, String date, String adult, String child) {


        mainPage.oneway.click();
        mainPage.destination.click();
        mainPage.destination.sendKeys(arrival);
        mainPage.airport.click();
        mainPage.setDepartDate(date);
        mainPage.passenger.click();

        int i = 0;
        int adultNum = Integer.parseInt(adult);
        int childNum = Integer.parseInt(child);

        while (i < adultNum - 1) {

            mainPage.Adult.click();
            i++;
        }
        while (i < childNum) {
            mainPage.Child.click();
            i++;
        }

        mainPage.search.click();
        BrowserUtils.scrollWithJS(mainPage.selectprice);
        mainPage.selectprice.click();
        BrowserUtils.waitForVisibility(mainPage.continueWithValue, 2);
        mainPage.continueWithValue.click();
        BrowserUtils.scrollWithJS(mainPage.Continue);
        BrowserUtils.waitForVisibility(mainPage.Continue, 2);
        mainPage.Continue.click();

    }

    @And("I enter passengers title {string} name {string} and  surname {string}")
    public void i_enter_passengers_title_name_and_surname(String title, String name, String surname) {

        BrowserUtils.waitForClickablility(mainPage.title, 2);
        BrowserUtils.scrollWithJS(mainPage.title);
        mainPage.title.click();
        mainPage.getTitle(title);
        mainPage.name.sendKeys(name);
        mainPage.surname.sendKeys(surname);
        BrowserUtils.hover(mainPage.Continue);
        mainPage.Continue.click();

    }

    @And("I select an available seat number for selection number {string}")
    public void i_select_an_available_seat_number_for_selection_number(String seat) {

        seatSelectionPage.SeatSelection(seat);
        BrowserUtils.waitForClickablility(seatSelectionPage.Continue, 2);
        seatSelectionPage.Continue.click();
        BrowserUtils.waitForClickablility(seatSelectionPage.smallbag, 3);
        seatSelectionPage.smallbag.click();
        seatSelectionPage.Continue2.click();
        seatSelectionPage.Continue2.click();
        creditCartPage.basketicon.click();
        BrowserUtils.waitForClickablility(creditCartPage.checkout, 2);
        creditCartPage.checkout.click();


    }

    @When("I pay for booking with card details {string} {string} and {string}")
    public void i_pay_for_booking_with_card_details_and(String cardnumber, String date, String cvv) throws InterruptedException {
        BrowserUtils.waitForClickablility(creditCartPage.countryCode, 2);
        creditCartPage.countryCode.click();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(creditCartPage.firstCountry).perform();
        BrowserUtils.scrollWithJS(creditCartPage.Sudan);
        creditCartPage.Spain.click();
        BrowserUtils.scrollUp();
        creditCartPage.phoneNumber.sendKeys("644820325");
        creditCartPage.noinsurance.click();
        BrowserUtils.scrollDown();
        BrowserUtils.waitForVisibility(creditCartPage.cardNumber, 2);
        BrowserUtils.clickWithJS(creditCartPage.cardNumber);
        creditCartPage.cardNumber.sendKeys(cardnumber);
        creditCartPage.setYearandMonth(date);
        creditCartPage.ccv.sendKeys(cvv);
        creditCartPage.cardHolderName.sendKeys("Musab Guzelel");
        creditCartPage.adressLine1.sendKeys("Calle Pio IX");
        creditCartPage.city.sendKeys("Valencia");
        creditCartPage.country.sendKeys("Spain", Keys.ENTER);
        creditCartPage.currency.click();
        creditCartPage.currencyType.click();
        creditCartPage.zipCode.sendKeys("46017");
        BrowserUtils.scrollWithJS(creditCartPage.clickPayTick);
        creditCartPage.clickPayTick.click();
        creditCartPage.payNow.click();


    }

    @Then("I should get payment declined message")
    public void i_should_get_payment_declined_message() {

        String errormessage = "Oops, something went wrong. Please check your payment details and try again";
        Assert.assertEquals(errormessage,creditCartPage.errorMessage.getText());
        System.out.println("creditCartPage.errormessage.getText() = " + creditCartPage.errorMessage.getText());

    }


}

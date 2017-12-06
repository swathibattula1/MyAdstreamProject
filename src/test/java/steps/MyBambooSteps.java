package steps;

import LIB.CommonClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BambooPage;
import pages.MakeBookingPage;
import pages.ResourceBookingPage;

import java.util.ArrayList;
import java.util.List;

public class MyBambooSteps extends CommonClass {
    private WebDriver driver = getDriver();

    @And("^I entered into MakeBooking screen$")
    public void iEnteredIntoMakeBookingScreen() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        resourceBookingPage.NavigateToMakeBooking();

    }

    @Given("^I am on Make Booking details page$")
    public void iAmOnMakeBookingDetailsPage() throws Throwable {
        System.out.println("I am on My Booking screen");
    }

    @And("^I clicked on MakeBooking button$")
    public void iClickedOnMakeBookingButton() throws Throwable {
        MakeBookingPage makeBookingPage = new MakeBookingPage(driver);
        makeBookingPage.clickMakeBooking();
    }

    @Then("^Booking is done$")
    public void bookingIsDone() throws Throwable {

        System.out.println("Booking is successfully done");

    }


    @And("^I entered following Booking details$")
    public void iEnteredFollowingBookingDetails(DataTable table1) throws Throwable {
        MakeBookingPage makeBookingPage = new MakeBookingPage(driver);
        List<MyAdstreamLoginSteps.BookingResource> bookingResources = new ArrayList<MyAdstreamLoginSteps.BookingResource>();
        bookingResources = table1.asList(MyAdstreamLoginSteps.BookingResource.class);
        for (MyAdstreamLoginSteps.BookingResource bookingResource : bookingResources) {
            makeBookingPage.EnterBookingResourceDetails(bookingResource.startTime, bookingResource.endTime, bookingResource.description);

        }
    }

    @Given("^I click on Home link$")
    public void iClickOnHomeLink() throws Throwable {
        driver.navigate().to("https://my.adstream.com");

    }

    @When("^I click on Mycareer icon$")
    public void iClickenOnMycareerIcon() throws Throwable {
        MakeBookingPage makeBookingPage = new MakeBookingPage(driver);
        makeBookingPage.NavigateToBambooPage();
    }

    @And("^I click on Technical Support Expert job link$")
    public void iClickOnReceptionistJobLink() throws Throwable {
        BambooPage bambooPage = new BambooPage(driver);
        bambooPage.ClickJobLink();
        Thread.sleep(2000);
    }

    @And("^I click on Apply for this job link$")
    public void iClickOnApplyForThisJobLink() throws Throwable {
        BambooPage bambooPage = new BambooPage(driver);
        bambooPage.ClickApplyForThisJob();
        Thread.sleep(2000);
    }


    @And("^Enter all details$")
    public void enterAllDetails(DataTable table) throws Throwable {
        BambooPage bambooPage = new BambooPage(driver);

    }


    @And("^Enter ([^\"]*) and ([^\"]*)$")
    public void enterKeyAndValues() throws Throwable {
        System.out.println("Test Method");
    }


    @And("^I job Enter all details$")
    public void iJobEnterAllDetails(DataTable table) throws Throwable {
        BambooPage bambooPage = new BambooPage(driver);
        bambooPage.EnterJobDetails1(table);

    }

    @Then("^I could submit CV$")
    public void iCouldSubmitCV() throws Throwable {
        System.out.println("CV submitted successfully");
    }
}

package steps;

import LIB.CommonClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MyAdstreamHomePage;
import pages.ResourceBookingPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BookResourceSteps extends CommonClass {
    private WebDriver driver = getDriver();

    @When("^I click on I Want to and then clicked on Book and then to A Resouce$")
    public void iClickOnIWantToAndThenClickedOnBookAndThenToAResouce() throws Throwable {
        MyAdstreamHomePage myAdstreamHomePage = new MyAdstreamHomePage(driver);
        myAdstreamHomePage.NavigateToResourceBookingPage();

    }

    @Then("^I should navigate to Book a Resource screen$")
    public void iShouldNavigateToBookAResourceScreen() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        resourceBookingPage.verifyResourceScreen();
    }

    @When("^I enter location$")
    public void iEnterLocation() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        Select location = new Select(driver.findElement(By.xpath(".//*[@id='location']")));
        location.selectByVisibleText("Tech HQ");
        Thread.sleep(2000);

    }

    @Given("^I am on Booking Resource Page$")
    public void iAmOnBookingResourcePage() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        System.out.println("I am on Booking Resource page");
        Thread.sleep(2000);
    }

    @And("^I enter category$")
    public void iEnterCategory() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(presenceOfElementLocated(By.xpath("./*//*[@id='category']")));
        Select category = new Select(driver.findElement(By.xpath("./*//*[@id='category']")));
        category.selectByVisibleText("Chill-Out Pod Chair");

    }

    @And("^I enter Resource$")
    public void iEnterResource() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(presenceOfElementLocated(By.xpath("./*//*[@id='resource']")));
        Select resource1 = new Select(driver.findElement(By.xpath("./*//*[@id='resource']")));
        resource1.selectByVisibleText("DeskCycle");
    }

    @And("^I clicked on CheckAvailability button$")
    public void iClickedOnCheckAvailabilityButton() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        click("xpath", ".//*[@id='submit2']");

    }

    @And("^I cleared Weeks of field$")
    public void iClearedWeeksOfField() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        ClearTextField("cssSelector", ".Form-TextBox");

    }

    @And("^I entered date in it$")
    public void iEnteredDateInIt() throws Throwable {
        sendKeys("cssSelector", ".Form-TextBox", "15/09/2017");
        Thread.sleep(1000);
    }

    @And("^I clicked on first date$")
    public void iClickedOnFirstDate() throws Throwable {
        ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);
        System.out.println("swathi");
        click("xpath", "//form[@id='frmBookingHome']/div/section//table[@class='unBorderedTable']/tbody/tr[3]/td[2]");

    }


}

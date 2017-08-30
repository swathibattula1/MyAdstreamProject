import LIB.CommonClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AbstractPage;
import pages.ResourceBookingPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BookingResourceSteps  extends CommonClass {
    WebDriver driver = getDriver();
    ResourceBookingPage resourceBookingPage = new ResourceBookingPage(driver);

    @When("^I enter location$")
    public void iEnterLocation() throws Throwable {
        Select location=new Select(driver.findElement(By.xpath(".//*[@id='location']")));
        location.selectByVisibleText("Tech HQ");
        Thread.sleep(2000);

    }

    @Given("^I am on Booking Resource Page$")
    public void iAmOnBookingResourcePage() throws Throwable {
        System.out.println("I am on Booking Resource page");
    }

    @And("^I enter category$")
    public void iEnterCategory() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(presenceOfElementLocated(By.xpath("./*//*[@id='category']")));
        Select category=new Select(driver.findElement(By.xpath("./*//*[@id='category']")));
        category.selectByVisibleText("Chill-Out Pod Chair");

    }

    @And("^I enter Resource$")
    public void iEnterResource() throws Throwable {
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(presenceOfElementLocated(By.xpath("./*//*[@id='resource']")));
        Select resource1=new Select(driver.findElement(By.xpath("./*//*[@id='resource']")));
        resource1.selectByVisibleText("DeskCycle");
    }

    @And("^I clicked on CheckAvailability button$")
    public void iClickedOnCheckAvailabilityButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I cleared Weeks of field$")
    public void iClearedWeeksOfField() throws Throwable {
        ClearTextField("cssSelector",".Form-TextBox");

    }

    @And("^I entered date in it$")
    public void iEnteredDateInIt() throws Throwable {
        sendKeys("cssSelector",".Form-TextBox","15/09/2017");
    }

    @And("^I clicked on first date$")
    public void iClickedOnFirstDate() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='RRB']/section/table/tbody/tr/td/table[3]/tbody/tr[3]/td[2]")).click();
        Thread.sleep(2000);
    }

    @Then("^I entered into MakeBooking screen$")
    public void iEnteredIntoMakeBookingScreen() throws Throwable {
        resourceBookingPage.verifyResourceScreen();

    }
}

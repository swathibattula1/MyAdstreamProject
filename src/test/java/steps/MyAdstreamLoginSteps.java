package steps;

import Base.BaseUtil;
import LIB.CommonClass;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Swathi.Battula on 13/08/2017.
 */
public class MyAdstreamLoginSteps extends CommonClass {

    WebDriver driver = getDriver();
    AbstractPage abstractPage = new AbstractPage(driver);

    @Given("^I navigate to MyAdstream Login screen$")
    public void i_navigate_to_MyAdstream_Login_screen() throws Throwable {
        abstractPage.NavigateToWebApp();

    }

    @When("^I entered following details$")
    public void i_entered_following_details(DataTable table) throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user : users) {
            landingPage.Login(user.username, user.password);

        }
    }

    @And("^I click on Login button$")
    public void i_click_on_Login_button() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.ClickLogin();

    }

    @Then("^I should see 'MyAdstream' home page$")
        public void i_should_see_MyAdstream_home_page() throws Throwable {
        MyAdstreamHomePage myAdstreamHomePage = new MyAdstreamHomePage(driver);
        myAdstreamHomePage.verifyHomepage();


    }


    @When("^I enter <username> and <password>$")
    public void iEnterUsernameAndPassword(DataTable table) throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user : users) {
            landingPage.Login(user.username, user.password);

        }
    }

    @When("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
        System.out.println("Username is: " + username + "and Password is: " + password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.Login(username, password);

    }

    @Given("^I am on 'MyAdstream' home page$")
    public void iAmOnMyAdstreamHomePage() throws Throwable {
        MyAdstreamHomePage myAdstreamHomePage = new MyAdstreamHomePage(driver);
        myAdstreamHomePage.verifyHomepage();
    }

    @And("^I logoff$")
    public void iLogoff() throws Throwable {
        MyAdstreamHomePage myAdstreamHomePage = new MyAdstreamHomePage(driver);
        myAdstreamHomePage.Logoff();
        Thread.sleep(1000);
    }


    public class User {
        public String username;
        public String password;

        public User(String name1, String password1) {
            this.username = name1;
            this.password = password1;
        }
    }

    public class BookingResource {
        public String startTime;
        public String endTime;
        public String description;

        public BookingResource(String startTime, String endTime, String description) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.description = description;
        }
    }

    public class JobDetails {
        public String key;
        public String values;

        public JobDetails(String key, String values) {
            this.key = key;
            this.values = values;
        }
    }


}

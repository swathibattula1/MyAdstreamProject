package pages;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import cucumber.runtime.Runtime;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import steps.MyAdstreamLoginSteps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BambooPage extends AbstractPage {
    public BambooPage(WebDriver driver) {
        super(driver);
    }

    public void ClickJobLink() throws InterruptedException {
        if (driver.findElement(By.xpath(".//*[@id='resultDiv']/div/ul/li[2]/div[2]/div[1]/a")).getText().equalsIgnoreCase("Technical Support Expert")) {
            driver.findElement(By.xpath(".//*[@id='resultDiv']/div/ul/li[2]/div[2]/div[1]/a")).click();
        }
    }

    public void ClickApplyForThisJob() {
        driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/a")).click();
    }

    public void i_entered_following_details(DataTable table) throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        List<MyAdstreamLoginSteps.User> users = new ArrayList<MyAdstreamLoginSteps.User>();
        users = table.asList(MyAdstreamLoginSteps.User.class);
        for (MyAdstreamLoginSteps.User user : users) {
            landingPage.Login(user.username, user.password);

        }
    }

    public void EnterJobDetails1(DataTable table) throws InterruptedException, IOException {
        List<List<String>> data = table.raw();

        sendKeys("xpath", ".//*[@id='applicationForm']/fieldset[1]/div[1]/div[1]/div/input", data.get(1).get(1));
        sendKeys("xpath", ".//*[@id='applicationForm']/fieldset[1]/div[1]/div[2]/div/input", data.get(2).get(1));
        sendKeys("xpath", ".//*[@id='applicationForm']/fieldset[1]/div[2]/div/div/input", data.get(3).get(1));
        sendKeys("xpath", ".//*[@id='applicationForm']/fieldset[1]/div[3]/div/div/input", data.get(4).get(1));
        sendKeys("xpath", ".//*[@id='address']", data.get(5).get(1));
        sendKeys("xpath", ".//*[@id='city']", data.get(6).get(1));
       /* click("cssSelector", ".chzn-single.chosen-default>div>b");


        sendKeys("cssSelector", ".ignore", "Angus");
        driver.findElement(By.cssSelector(".ignore")).sendKeys(Keys.ENTER);*/

       sendKeys("cssSelector",".state.state-field.text.wide.js-state-input","sabah");
        Thread.sleep(1000);


        click("linkText", "Choose File");
        java.lang.Runtime.getRuntime().exec("C:\\Users\\swathi.battula\\Desktop\\FileUpload2.exe");
        sendKeys("id", "zip", "E78PD");
        click("xpath", ".//*[@id='applicationForm']/fieldset[2]/div[2]/div/div/button");
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[5]/a")).click();

        sendKeys("id","salary","30K");

    }

}




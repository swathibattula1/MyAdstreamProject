package pages;


import LIB.CommonClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractPage extends CommonClass {
    public AbstractPage(WebDriver driver) {

        this.driver = driver;
    }


    public LandingPage NavigateToWebApp() throws InterruptedException {
        driver.navigate().to("https://my.adstream.com");
        Thread.sleep(2000);
        return new LandingPage(driver);
    }



    public void CloseTest(Scenario scenario){

        if(scenario.isFailed()){
            System.out.println("screenshot");
        }
    }

    public void closeDriver() {
        driver.quit();
    }
}

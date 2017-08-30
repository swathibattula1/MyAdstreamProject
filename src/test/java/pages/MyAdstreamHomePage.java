package pages;

import LIB.CommonClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MyAdstreamHomePage extends AbstractPage {


    public MyAdstreamHomePage(WebDriver driver) {
        super(driver);
    }
    public void verifyHomepage() throws InterruptedException {
        driver.manage().window().maximize();
         verifyTitle("MyAdstream");
         Thread.sleep(2000);
    }

    public ResourceBookingPage NavigateToResourceBookingPage() throws InterruptedException {

        WebElement iWantTo1=webElementId("linkText","I Want To...");
        WebElement book=webElementId("xpath",".//*[@id='ulMenuMain']/li[6]/ul/li[1]/a");

        WebElement resource=webElementId("xpath",".//*[@id='ulMenuMain']/li[6]/ul/li[1]/ul/li[1]/a/span");
        Actions builder = new Actions(super.driver);
        Action act1=builder.moveToElement(iWantTo1).moveToElement(book).moveToElement(resource).doubleClick().build();
        act1.perform();
        Thread.sleep(2000);

        return new ResourceBookingPage(driver);
    }

}

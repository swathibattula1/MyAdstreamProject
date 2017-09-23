package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MakeBookingPage extends AbstractPage {
    public MakeBookingPage(WebDriver driver) {
        super(driver);
    }


    public void EnterBookingResourceDetails(String startTime, String endTime, String description) throws InterruptedException {
        click("cssSelector", "#starttime");
        WebElement calStarttime = webElementId("cssSelector", "#starttime");
        /*List<WebElement> elements= driver.findElements(By.cssSelector("#starttime"));
        System.out.println(elements.size());
        for(WebElement element:elements){
            System.out.println(element.getText());
        }
*/
        if (driver.findElement(By.cssSelector("#starttime")).getText().equalsIgnoreCase(startTime)) {
            click("cssSelector", "#starttime");
        }
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(2000);


        if (driver.findElement(By.cssSelector("#endtime")).getText().equalsIgnoreCase(endTime)) {
            click("cssSelector", "#endtime");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement btndescription = webElementId("xpath", ".//*[@id='RRB']/section/table/tbody/tr/td/table[2]/tbody/tr[3]/td[1]/table/tbody/tr[6]/td[2]/textarea");
        btndescription.sendKeys(description);

    }

    public void clickMakeBooking() {

        System.out.println("Booking is done");
    }

    public void NavigateToHomePage() throws InterruptedException {
        click("xpath", ".//*[@id='lnkHome']/div");
        Thread.sleep(2000);
    }

    public BambooPage NavigateToBambooPage() throws InterruptedException {

        click("xpath", "./*//*[@id='widgetBody']/div/div/div/fieldset/div/div/a/img");
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        return new BambooPage(driver);
    }
}

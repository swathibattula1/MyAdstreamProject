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

    // WebElement calStarttime = webElementId("cssSelector", "#starttime");
    // WebElement calEendtime = webElementId("cssSelector", "#endtime");
    // WebElement btndescription = webElementId("xpath", ".//*[@id='RRB']/section/table/tbody/tr/td/table[2]/tbody/tr[3]/td[1]/table/tbody/tr[6]/td[2]/textarea");
    // WebElement btnMakeBooking = webElementId("xpath", ".//*[@id='button1']");

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

        /*click("cssSelector", "#endtime");
        List<WebElement> elements = driver.findElements(By.cssSelector("#endtime"));
        System.out.println(elements.size());
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }*/
        if (driver.findElement(By.cssSelector("#endtime")).getText().equalsIgnoreCase(endTime)) {
            click("cssSelector", "#endtime");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement btndescription = webElementId("xpath", ".//*[@id='RRB']/section/table/tbody/tr/td/table[2]/tbody/tr[3]/td[1]/table/tbody/tr[6]/td[2]/textarea");
       /* Select calenderendTime=new Select(driver.findElement(By.cssSelector("#endtime")));
        calenderendTime.selectByVisibleText(endTime);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/
        btndescription.sendKeys(description);


       /* WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(presenceOfElementLocated(By.xpath(".//div[@id='RRB']//input[@id='button1']")));

        click("xpath",".//div[@id='RRB']//input[@id='button1']");
        driver.switchTo().defaultContent();*/
    }

    public void clickMakeBooking() {
        WebElement btnMakeBooking = webElementId("xpath", ".//*[@id='button1']");
        btnMakeBooking.click();
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

        // Perform the actions on new window
        List<WebElement> elements = driver.findElements(By.xpath("//form[@id='frmBookingHome']/div/section//table[@class='unBorderedTable']/tbody/tr[2]"));
        System.out.println(elements.size());
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        return new BambooPage(driver);
    }
}

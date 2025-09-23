package tests.Assignment.Day01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SoftAssertLoginTest {

    WebDriver driver;
    String url = "https://claruswaysda.github.io/signIn.html";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void softAssertLoginTest() {
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        try {
            Alert alert = driver.switchTo().alert();
            softAssert.assertNotNull(alert, "Alert is not displayed");

            String actualAlertText = alert.getText();
            String expectedAlertText = "Incorrect username or password";
            softAssert.assertEquals(actualAlertText, expectedAlertText, "Alert message text does not match");

            alert.accept();
        } catch (Exception e) {
            softAssert.fail("No alert was triggered after submitting wrong credentials");
        }

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

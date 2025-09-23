package tests.Assignment.Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HardAssertLoginTest {
    //1. Navigate to https://claruswaysda.github.io/signIn.html
    //2. Enter username: "admin"
    //3. Enter password: "123"
    //4. Click Submit button
    //5. Use hard assertions to verify:
       //New page URL is "https://claruswaysda.github.io/signIn.html"
       //Page contains text "Employee Table"

    WebDriver driver;
    String url = "https://claruswaysda.github.io/signIn.html";

    @Test
    void hardAssert(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String expectedurl ="https://claruswaysda.github.io/signIn.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedurl,"Url is not matching");

        // Hard assert for text "Employee Table"
        String expectedText = "Employee Table";
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedText), "Text 'Employee Table' not found on the page");

    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}

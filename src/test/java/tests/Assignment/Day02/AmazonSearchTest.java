package tests.Assignment.Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonSearchTest {

    //        Requirements:
    //            1. Navigate to: https://www.amazon.com
    //            2. Search for different keywords: Java, Selenium
    //            3. Assert that result text contains the searched word
    //            4. Run tests from XML file using parameters


    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    @Parameters("keyword")
    public void amazonSearchTest(String keyword) {
        driver.get("https://www.amazon.com");

        WebElement continueBtn = driver.findElement(By.xpath("//button[text()='Continue shopping']"));
        continueBtn.click();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(keyword);
        searchBox.submit();

        WebElement resultText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String text = resultText.getText();

        Assert.assertTrue(text.toLowerCase().contains(keyword.toLowerCase()), "Result text does not contain the searched keyword!");
        System.out.println("Searched for: " + keyword + " = Result: " + text);
    }
}
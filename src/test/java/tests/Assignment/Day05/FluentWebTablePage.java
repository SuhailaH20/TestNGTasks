package tests.Assignment.Day05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.WebTablePage;

import java.time.Duration;

public class FluentWebTablePage {

    WebDriver driver;
    WebTablePage webTablePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        webTablePage = new WebTablePage(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void addMultipleRecordsTest() {
        String[][] data = {
                {"John", "25", "USA"},
                {"Maria", "30", "Germany"},
                {"Ahmed", "28", "Canada"},
                {"Sophie", "24", "UK"},
                {"Raj", "32", "Australia"}
        };

        for (String[] record : data) {

            //applying the fluent POM!!!!
            webTablePage
                    .enterName(record[0])
                    .enterAge(record[1])
                    .selectCountry(record[2])
                    .clickAddRecord();

            // Fetch last row after each add
            String lastRow = webTablePage.getLastRowText();

            Assert.assertTrue(lastRow.contains(record[0]), "Name not found in last row");
            Assert.assertTrue(lastRow.contains(record[1]), "Age not found in last row");
            Assert.assertTrue(lastRow.contains(record[2]), "Country not found in last row");
        }

        // Final assertion → table has exactly 5 rows
        Assert.assertEquals(webTablePage.getRowCount(), 8, "Table row count should be 5");
    }


}

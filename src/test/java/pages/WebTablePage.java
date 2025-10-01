package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablePage {
    private WebDriver driver;

    // Locators
    private By nameInput = By.id("nameInput");
    private By ageInput = By.id("ageInput");
    private By countrySelect = By.id("countrySelect");
    private By addButton = By.xpath("//button[text()='Add Record']");
    private By lastRow = By.xpath("//table[@id='recordTable']/tbody/tr[last()]");

    // Constructor
    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Fluent methods
    public WebTablePage enterName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public WebTablePage enterAge(String age) {
        driver.findElement(ageInput).clear();
        driver.findElement(ageInput).sendKeys(age);
        return this;
    }

    public WebTablePage selectCountry(String country) {
        driver.findElement(countrySelect).sendKeys(country); // OR Select class
        return this;
    }

    public WebTablePage clickAddRecord() {
        driver.findElement(addButton).click();
        return this;
    }

    public String getLastRowText() {
        List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
        return rows.get(rows.size() - 1).getText();  // always fetch last row
    }

    public int getRowCount() {
        return driver.findElements(By.cssSelector("table tbody tr")).size();
    }

}

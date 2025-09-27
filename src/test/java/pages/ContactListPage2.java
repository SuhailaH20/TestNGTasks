package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPage2 {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By addContactBtn = By.id("add-contact");
    private By contactTable = By.id("contactTable"); // <-- adjust to actual contact list locator

    public ContactListPage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Wait until Contact List page is visible
    public void waitForContactListPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addContactBtn));
    }

    // Click "Add a New Contact"
    public void clickAddContact() {
        wait.until(ExpectedConditions.elementToBeClickable(addContactBtn)).click();
    }
}

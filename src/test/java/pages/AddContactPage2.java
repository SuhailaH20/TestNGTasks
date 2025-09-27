package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddContactPage2 {
    private WebDriver driver;
    private WebDriverWait wait;
    private By addContactbtn = By.id("add-contact");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By birthdate = By.id("birthdate");
    private By email = By.id("email");
    private By phone = By.id("phone");
    private By street1 = By.id("street1");
    private By street2 = By.id("street2");
    private By city = By.id("city");
    private By stateProvince = By.id("stateProvince");
    private By postalCode = By.id("postalCode");
    private By country = By.id("country");
    private By submitBtn = By.id("submit"); // make sure this exists in HTML!

    public AddContactPage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void addContact(String fName, String lName, String mail, String phoneNum) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(phone).sendKeys(phoneNum);
        driver.findElement(submitBtn).click();


    }



    public void addContactFull(String fName, String lName, String birth, String mail, String phoneNum,
                               String street, String cityName, String state, String zip, String countryName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(birthdate).sendKeys(birth);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(phone).sendKeys(phoneNum);
        driver.findElement(street1).sendKeys(street);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(stateProvince).sendKeys(state);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(country).sendKeys(countryName);
        driver.findElement(submitBtn).click();
    }
}

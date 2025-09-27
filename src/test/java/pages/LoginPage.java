package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By signupEmailField = By.id("email");
    private By signupPasswordField = By.id("password");
    private By signupSubmitBtn = By.id("submit");

    // --- Navigation button to Sign Up page ---
    private By signupNavBtn = By.id("signup");

    // Actions
    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {

        driver.findElement(submitButton).click();
    }

    // Full login method
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public void register(String firstName, String lastName, String email, String password) {
        driver.findElement(signupNavBtn).click();       // go to signup page
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(signupEmailField).sendKeys(email);
        driver.findElement(signupPasswordField).sendKeys(password);
        driver.findElement(signupSubmitBtn).click();
    }
}

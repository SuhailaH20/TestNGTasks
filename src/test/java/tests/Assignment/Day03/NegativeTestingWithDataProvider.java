package tests.Assignment.Day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestingWithDataProvider extends TestBase {

    /*
    Go to https://claruswaysda.github.io/signIn.html
    Do negative test with all scenarios
    */


    @DataProvider
    public static Object[][] getNegativeLoginData() {
        return new Object[][] {
                {"admin", "wrongPass"},
                {"wrongUser", "123"},
                {"", "123"},
                {"admin", ""},
                {"wrongUser", "wrongPass"},
                {"", ""}
        };
    }


    @Test(dataProvider = "getNegativeLoginData")
    void negativeLoginTest(String username, String password) {

        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        if (username.isEmpty()) {
            Assert.assertEquals(getValidationMsg(By.id("username")), "Please fill in this field.");

        } else if (password.isEmpty()) {
            Assert.assertEquals(getValidationMsg(By.id("password")), "Please fill in this field.");

        } else {
            String errorMsg = driver.switchTo().alert().getText();
            Assert.assertEquals(errorMsg, "Incorrect username or password");

        }

    }

    private String getValidationMsg(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", element);
    }

}
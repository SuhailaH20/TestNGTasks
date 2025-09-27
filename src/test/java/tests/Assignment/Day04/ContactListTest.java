package tests.Assignment.Day04;

import org.testng.annotations.Test;
import pages.ContactListPage2;
import utilities.TestBase;
import pages.LoginPage;
import pages.AddContactPage2;


public class ContactListTest extends TestBase {

    @Test
    void Contactlisttest() throws InterruptedException {

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        ContactListPage2 contactListPage = new ContactListPage2(driver);

        //Create User
        String firstName = "Test";
        String lastName = "User";
        String email = "user" + System.currentTimeMillis() + "@test.com";
        String password = "Password123545892937923989429482948243!";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.register(firstName, lastName, email, password);
        //   loginPage.login("testuser@example.com", "password123");

        //click the add btn
        contactListPage.clickAddContact();

        //add users
        AddContactPage2 addContactPage = new AddContactPage2(driver);

        addContactPage.addContact(
                "First" ,
                "Last" ,
                "contact" +  "@mail.com",
                "12345678"
        );

        for (int i = 1; i <= 5; i++) {
            contactListPage.waitForContactListPage();
            contactListPage.clickAddContact();
            addContactPage.addContact(
                    "First"+i,
                    "Last"+i ,
                    "contact" + i+ "@mail.com",
                    "12345678"+i
            );

        }

    }

}

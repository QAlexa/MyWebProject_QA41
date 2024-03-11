package tests;

import config.BaseTest;
import helpers.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import model.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactsPage;
import pages.LoginPage;
import pages.MainPage;

public class PhoneBookTest extends BaseTest {

    @Test(description = "The test checks the empty field warning declaration.")
    @Parameters("browser")
    public void registrationWithoutPassword(@Optional("chrome") String browser) throws InterruptedException {
        Allure.description("User already exist. Login and add contact.!");

        MainPage mainPage = new MainPage(getDriver());
        Allure.step("Click by Login button");
        LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        Allure.step("Click by Reg button");
        String expectedString = "Wrong";

        Alert alert= loginPage.fillEmailField("myemail@mail.com").clickByRegistartionBUtton();
        boolean isAlertHandled = AlertHandler.handleAlert(alert, expectedString);
        Assert.assertTrue(isAlertHandled);

    }
    @Test
    @Description("User already exist. Login and add contact.")
    public void loginOfAnExistingUserAddContact() throws InterruptedException {
        Allure.description("User already exist. Login and add contact.!");
        MainPage mainPage = new MainPage(getDriver());
        Allure.step("Step 1");
        LoginPage lpage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        Allure.step("Step 2");
        lpage.fillEmailField(PropertiesReader.getProperty("existingUserEmail"))
                .fillPasswordField(PropertiesReader.getProperty("existingUserPassword"))
                .clickByLoginButton();
        Allure.step("Step 3");
        MainPage.openTopMenu(TopMenuItem.ADD.toString());
        AddPage addPage = new AddPage(getDriver());
        Contact newContact = new Contact(NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                PhoneNumberGenerator.generatePhoneNumber(),
                EmailGenerator.generateEmail(10,5,3),
                AddressGenerator.generateAddress(),
                "new description");
        newContact.toString();
        addPage.fillFormAndSave(newContact);
        ContactsPage contactsPage = new ContactsPage(getDriver());
        Assert.assertTrue(contactsPage.getDataFromContactList(newContact));
        TakeScreen.takeScreenshot("screen");
        Thread.sleep(3000);

    }

    @Test
    @Description("Registration successful")

    public void testRegistrationSuccess() throws Exception {

        //Allure description("New Registration, user is not registered ");
        MainPage mainPage = new MainPage(getDriver());
        Allure.step("Step 1");
        LoginPage lpage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        Allure.step("Step 2");
        lpage.fillEmailField(EmailGenerator.generateEmail(5,1,3))
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistartionBUtton();
        Allure.step("Step 3");
        Allure.step("Step 3");
        Assert.assertTrue(new ContactsPage().isElementPresent(By.xpath("//button")));
        TakeScreen.takeScreenshot("screening");



    }
}
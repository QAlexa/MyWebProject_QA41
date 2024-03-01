package tests;

import config.BaseTest;
import helpers.TopMenuItem;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class PhoneBookTest extends BaseTest {
@Test

    public void testPhoneBook_001() throws InterruptedException {
    MainPage mainPage = new MainPage(getDriver());
    LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());

    Thread.sleep(5000);
}

}

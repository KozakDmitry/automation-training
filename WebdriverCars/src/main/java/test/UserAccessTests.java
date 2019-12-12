package test;

import org.junit.jupiter.api.Test;
import model.Account;
import org.openqa.selenium.WebDriver;
import pages.StartPage;
import service.AccountCreator;
import org.testng.Assert;



public class UserAccessTests extends CommonConditions {

    @Test
    public void loginWithNotRegisteredEmailTest() {
        Account testAccount = AccountCreator.withEmptyEmail();
        StartPage page = new StartPage(driver);
        page.login(testAccount);
        Assert.assertTrue(page.isErrorMessageVisible(driver));
    }
}
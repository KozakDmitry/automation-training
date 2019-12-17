package test;

import org.junit.jupiter.api.Test;
import service.PageErrorCreator;
import model.PageError;
import pages.StartPage;
import service.AccountCreator;
import org.testng.Assert;



public class UserAccessTests extends CommonConditions {

    @Test
    public void LoginWithEmptyField(){
        StartPage page = new StartPage(driver)
                .openPage()
                .inputDataAccount(AccountCreator.withEmptyFields());
        PageError expectedError = PageErrorCreator.errorLoginForEmptyFields();
        Assert.assertTrue(page.checkPlaceLoginErrorMessage(expectedError));
    }

    @Test
    public void loginWithNotRegisteredEmailTest() {
        StartPage page = new StartPage(driver)
                  .openPage()
                  .inputDataAccount(AccountCreator.withNotRegisteredEmail());
        PageError expectedError = PageErrorCreator.errorLoginWithNotRegisteredEmail();
        Assert.assertTrue(page.checkPlaceLoginErrorMessage(expectedError));
    }

    @Test
    public void loginWithRegisteredEmailTest() {
        StartPage page = new StartPage(driver)
                .openPage()
                .inputDataAccount(AccountCreator.withRegisteredEmail());
        Assert.assertTrue(page.isLoginSuccess());
    }

    @Test
    public void registerWithWrongEmailTest() {
        StartPage page = new StartPage(driver)
                .openPage()
                .inputRegisterData(AccountCreator.withWrongEmail());
        PageError expectedError = PageErrorCreator.errorWithWrongEmail();
        Assert.assertTrue(page.checkPlaceRegisterErrorMessage(expectedError));
    }

}
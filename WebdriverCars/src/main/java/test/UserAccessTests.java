package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import service.PageErrorCreator;
import model.PageError;
import pages.StartPage;
import service.AccountCreator;
import org.testng.Assert;



public class UserAccessTests extends CommonConditions {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @Test
    public void LoginWithEmptyField(){
        LOGGER.info("Test LoginWithEmptyField started");
        StartPage page = new StartPage(driver)
                .openPage()
                .inputDataAccount(AccountCreator.withEmptyFields());
        PageError expectedError = PageErrorCreator.errorLoginForEmptyFields();
        Assert.assertTrue(page.checkPlaceLoginErrorMessage(expectedError));
    }

    @Test
    public void loginWithNotRegisteredEmailTest() {
        LOGGER.info("Test LoginWithUnregisteredEmail started");
        StartPage page = new StartPage(driver)
                  .openPage()
                  .inputDataAccount(AccountCreator.withNotRegisteredEmail());
        PageError expectedError = PageErrorCreator.errorLoginWithNotRegisteredEmail();
        Assert.assertTrue(page.checkPlaceLoginErrorMessage(expectedError));
    }

    @Test
    public void loginWithRegisteredEmailTest() {
        LOGGER.info("Test  LoginWithProperData started");
        StartPage page = new StartPage(driver)
                .openPage()
                .inputDataAccount(AccountCreator.withRegisteredEmail());
        Assert.assertTrue(page.isLoginSuccess());
    }

    @Test
    public void registerWithWrongEmailTest() {
        LOGGER.info("Test LoginWithWrongEmail started");
        StartPage page = new StartPage(driver)
                .openPage()
                .inputRegisterData(AccountCreator.withWrongEmail());
        PageError expectedError = PageErrorCreator.errorWithWrongEmail();
        Assert.assertTrue(page.checkPlaceRegisterErrorMessage(expectedError));
    }



}
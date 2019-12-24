package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import model.PageError;
import service.AccountCreator;
import service.PageErrorCreator;
import service.CarCreator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.StartPage;
import model.Car;

public class StartPageTest extends CommonConditions{
    private StartPage page;
    private static final Logger LOGGER = LogManager.getRootLogger();



    @Test
    public void pickUpTimeIsBeforeTheCurrentTime() {
        LOGGER.info("Test with PickUpBeforeNow started");
        page = new StartPage(driver)
                .openPage()
                .inputData(CarCreator.withNegativeRentalPeriodFromProperty());
        PageError expectedError = PageErrorCreator.errorForNegativeRentalPeriodFromProperty();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void searchFromDifferentContinents() {
        LOGGER.info("Test with DifferentContinents started");
        page = new StartPage(driver)
                .openPage()
                .inputData(CarCreator.withDifferentContinets());
        PageError expectedError = PageErrorCreator.errorForNoCars();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void searchToImaginaryPlace() {
        LOGGER.info("Test with ImaginaryPlace started");
        page = new StartPage(driver);
        PageError expectedError = PageErrorCreator.errorForNoCars();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void LoginWithEmptyField(){
        LOGGER.info("Test LoginWithEmptyField started");
        page = new StartPage(driver);
        PageError expectedError = PageErrorCreator.errorLoginForEmptyFields();
        Assert.assertTrue(page.checkPlaceLoginErrorMessage(expectedError));
    }

    @Test
    public void loginWithNotRegisteredEmailTest() {
        LOGGER.info("Test LoginWithUnregisteredEmail started");
        page = new StartPage(driver)
                .openPage()
                .inputDataAccount(AccountCreator.withNotRegisteredEmail());
        PageError expectedError = PageErrorCreator.errorLoginWithNotRegisteredEmail();
        Assert.assertTrue(page.checkPlaceLoginErrorMessage(expectedError));
    }

    @Test
    public void loginWithRegisteredEmailTest() {
        LOGGER.info("Test  LoginWithProperData started");
        page = new StartPage(driver)
                .openPage()
                .inputDataAccount(AccountCreator.withRegisteredEmail());
        Assert.assertTrue(page.isLoginSuccess());
    }

    @Test
    public void searchWithEmptyFields() {
        LOGGER.info("Test with EmtyFiels started");
        page = new StartPage(driver)
                .inputData(CarCreator.withEmptyFields());
        PageError expectedError = PageErrorCreator.errorForEmptyFields();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void registerWithWrongEmailTest() {
        LOGGER.info("Test LoginWithWrongEmail started");
        page = new StartPage(driver)
                .openPage()
                .inputRegisterData(AccountCreator.withWrongEmail());
        PageError expectedError = PageErrorCreator.errorWithWrongEmail();
        Assert.assertTrue(page.checkPlaceRegisterErrorMessage(expectedError));
    }




}
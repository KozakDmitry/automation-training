package test;

import model.CarRent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import model.PageError;
import service.AccountCreator;
import service.CarRentCreator;
import service.PageErrorCreator;
import service.CarCreator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.StartPage;
import pages.SearchCarPage;
import model.Car;

public class SearchCarPageTest extends CommonConditions{
    private SearchCarPage page;
    private static final Logger LOGGER = LogManager.getRootLogger();

    @Test
    public void rentCarWithInsuranceWithoutCreditCard() {
    LOGGER.info("Test with Insurance started");
        page = new SearchCarPage(driver);
        PageError expectedError = PageErrorCreator.errorWithoutCreditCard();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void rentCarWithWrongNumber() {
        LOGGER.info("Test with WrongNumber started");
        page = new SearchCarPage(driver);
        PageError expectedError = PageErrorCreator.errorWithWrongNumber();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }


}

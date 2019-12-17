package test;

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
    private WebDriver driver;
    private StartPage page;



    @Test
    public void pickUpTimeIsBeforeTheCurrentTime() {
        page = new StartPage(driver)
                .openPage()
                .inputData(CarCreator.withNegativeRentalPeriodFromProperty());
        PageError expectedError = PageErrorCreator.errorForNegativeRentalPeriodFromProperty();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void searchWithEmptyFields() {
        page = new StartPage(driver)
                .openPage()
                .inputData(CarCreator.withEmptyFields());
        PageError expectedError = PageErrorCreator.errorForEmptyFields();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void searchFromDifferentContinents() {
        page = new StartPage(driver)
                .openPage()
                .inputData(CarCreator.withDifferentContinets());
        PageError expectedError = PageErrorCreator.errorForNoCars();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void searchToImaginaryPlace() {
        page = new StartPage(driver)
                .openPage()
                .inputData(CarCreator.withImaginaryPlace());
        PageError expectedError = PageErrorCreator.errorForNoCars();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }




    @AfterClass
    public void browserTearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
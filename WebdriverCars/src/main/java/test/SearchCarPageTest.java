package test;

import model.CarRent;
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
    private WebDriver driver;
    private SearchCarPage page;

    @Test
    public void rentCarWithInsuranceWithoutCreditCard() {
        page = new SearchCarPage(driver)
                .openPage()
                .InputDataPerson(CarRentCreator.withoutCreditCard());
        PageError expectedError = PageErrorCreator.errorWithoutCreditCard();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test
    public void rentCarWithWrongNumber() {
        page = new SearchCarPage(driver)
                .openPage()
                .InputDataPerson(CarRentCreator.withWrongNumber());
        PageError expectedError = PageErrorCreator.errorWithWrongNumber();
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

package test;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.StartPage;
import model.Car;
import java.time.LocalDate;
import java.time.LocalTime;

public class StartPageTest extends CommonConditions{
    private WebDriver driver;
    private StartPage page;



    @Test
    public void pickUpTimeIsBeforeTheCurrentTime(Car Car) {
        page = new StartPage(driver)
                .openPage()
                .pickUpTimeIsBeforeTheCurrentTime(Car.getPickUpPlace(), Car.getpickUpDate(), Car.getdropOffDate());
        Assert.assertTrue(page.isErrorMessageVisible(driver));
    }

    @Test
    public void searchWithEmptyPickUpField(Car Car) {
        page = new StartPage(driver)
                .openPage()
                .searchWithEmptyPickUpField(Car.getPickUpPlace(), Car.getpickUpDate(), Car.getdropOffDate());
        Assert.assertTrue(page.isErrorMessageVisible(driver));
    }

    @Test
    public void searchWithWrongPickUpField(Car Car) {
        page = new StartPage(driver)
                .openPage()
                .searchWithWrongPickUpField(Car.getPickUpPlace(), Car.getpickUpDate());
        Assert.assertTrue(page.isErrorMessageVisible(driver));
    }


    @AfterClass
    public void browserTearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
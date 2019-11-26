import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class StartPageTest {
    private WebDriver driver;
    private StartPage page;
    private final String pickUpPlace = "Minsk";
    private final String EmptyPickUpPlace = "";
    private final String WrongPickUpPlace = "dgsdgsdggsg";
    private final LocalDate pickUpDate = LocalDate.now().minusDays(1);
    private final LocalDate dropOffDate = LocalDate.now().plusDays(1);
    private final LocalTime currentTime = LocalTime.NOON;

    @BeforeClass
    public void browserSetUp() {
        driver = new EdgeDriver();
    }

    @Test
    public void pickUpTimeIsBeforeTheCurrentTime() {
        page = new StartPage(driver)
                .openPage()
                .pickUpTimeIsBeforeTheCurrentTime(pickUpPlace, pickUpDate, dropOffDate);
        Assert.assertTrue(page.isErrorMessageVisible(driver));
    }

    @Test
    public void searchWithEmptyPickUpField() {
        page = new StartPage(driver)
                .openPage()
                .searchWithEmptyPickUpField(EmptyPickUpPlace, pickUpDate);
        Assert.assertTrue(page.isErrorMessageVisible(driver));
    }

    @Test
    public void searchWithWrongPickUpField() {
        page = new StartPage(driver)
                .openPage()
                .searchWithWrongPickUpField(WrongPickUpPlace, pickUpDate);
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
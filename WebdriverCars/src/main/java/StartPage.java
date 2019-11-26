import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class StartPage extends AbstractPage{
    private final String PAGE_URL = "https://www.kayak.com/horizon/sem/cars/general";
    private final int WAIT_TIMEOUT_SECONDS = 15;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");


    public StartPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    @Override
    public StartPage openPage() {
        webDriver.get(PAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"uO2g-pickup-display-inner\"]")
    private WebElement pickUpPlace;

    @FindBy(xpath = "//[@id=\"car-dropoff-clp\"]")
    private WebElement dropOffPlace;

    @FindBy(xpath = "//*[@id=\"uO2g-dateRangeInput-display-start-inner\"]")
    private WebElement pickUpDate;

    @FindBy(xpath = "//*[@id=\"uO2g-dateRangeInput-display-end-inner\"]")
    private WebElement dropOffDate;

    @FindBy(xpath = "//*[@id=\"uO2g-dateRangeInput-start-time\"]")
    private WebElement pickUpTime;

    @FindBy(xpath = "//*[@id=\"uO2g-dateRangeInput-end-time\"]")
    private WebElement dropOffTime;

    @FindBy(xpath = "//*[@id=\"uO2g-submit\"]")
    private WebElement searchButton;

    private void searchCar() {
        searchButton.click();
    }

    private StartPage selectPickUpTime(LocalTime picTime) {
        new Select(pickUpTime).selectByVisibleText(picTime.format(timeFormatter));
        return this;
    }

    private StartPage selectDropOffTime(LocalTime dropTime) {
        new Select(dropOffTime).selectByVisibleText(dropTime.format(timeFormatter));
        return this;
    }

    private StartPage inputPickUpPlace(String place) {
        pickUpPlace.clear();
        pickUpPlace.sendKeys(place);
        return this;
    }

    private StartPage inputDropOffPlace(String place) {
        dropOffPlace.clear();
        dropOffPlace.sendKeys(place);
        return this;
    }

    private StartPage inputPickUpDate(LocalDate date) {
        pickUpDate.clear();
        pickUpDate.sendKeys(date.format(dateFormatter));
        return this;
    }

    private StartPage inputDropOffDate(LocalDate date) {
        dropOffDate.clear();
        dropOffDate.sendKeys(date.format(dateFormatter));
        return this;
    }

    public boolean isErrorMessageVisible(WebDriver driver) {
        WebElement errorMessage =
                new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"c2O1F-dialog-body\"]/div")));
        return errorMessage.isDisplayed();
    }


    public StartPage pickUpTimeIsBeforeTheCurrentTime(String pickUpPlace, LocalDate pickUpDate, LocalDate dropOffDate) {
        inputPickUpPlace(pickUpPlace);
        inputPickUpDate(pickUpDate);
        inputDropOffDate(dropOffDate);
        searchCar();
        return this;
    }

    public StartPage searchWithWrongPickUpField(String WrongPickUpPlace, LocalDate pickUpDate) {
        inputPickUpPlace(WrongPickUpPlace);
        inputPickUpDate(pickUpDate);
        inputDropOffDate(pickUpDate);
        searchCar();
        return this;
    }

    public StartPage searchWithEmptyPickUpField(String EmptyPickUpPlace, LocalDate pickUpDate) {
        inputPickUpPlace(EmptyPickUpPlace);
        inputPickUpDate(pickUpDate);
        inputDropOffDate(pickUpDate);
        searchCar();
        return this;
    }

}
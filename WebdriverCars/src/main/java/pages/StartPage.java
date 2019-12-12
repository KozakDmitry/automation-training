package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.PageError;
import model.Account;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class StartPage extends AbstractPage{
    private final String PAGE_URL = "https://www.kayak.com/horizon/sem/cars/general";
    private final Logger LOGGER = LogManager.getRootLogger();
    private final int WAIT_TIMEOUT_SECONDS = 15;


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

    @FindBy(xpath = "//*[@id=\"TCe_-username\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"TCe_-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"TCe_-submit\"]")
    private WebElement submitButton;

    @FindBy(className = "_itL")
    private WebElement invalidEmail;

    public StartPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    @Override
    public StartPage openPage() {
        webDriver.get(PAGE_URL);
        LOGGER.info("Page was opened");
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }


    private void searchCar() {
        searchButton.click();
        LOGGER.info("Searching...");
    }

    private StartPage selectPickUpTime(String picTime) {
        new Select(pickUpTime);
        return this;
    }

    public boolean checkOfferToRegisterMessage(PageError error) {
        return invalidEmail.isDisplayed()
                && invalidEmail.getText().
                contains(error.getErrorDescription());
    }

    public StartPage login(Account account)
    {
        emailInput.sendKeys(account.getEmail());
        passwordInput.sendKeys(account.getPassword());
        submitButton.click();
        LOGGER.info("Login performed");
        return new StartPage(webDriver);
    }


    private StartPage selectDropOffTime(String dropTime) {
        new Select(dropOffTime);
        return this;
    }

    private StartPage inputPickUpPlace(String place) {
        pickUpPlace.clear();
        pickUpPlace.sendKeys(place);
        LOGGER.info("PickUpPlace was sended");
        return this;
    }

    private StartPage inputDropOffPlace(String place) {
        dropOffPlace.clear();
        dropOffPlace.sendKeys(place);
        LOGGER.info("DropOffPlace was sended");
        return this;
    }

    private StartPage inputPickUpDate(String date) {
        pickUpDate.clear();
        pickUpDate.sendKeys(date);
        LOGGER.info("PickUpDate was sended");
        return this;
    }

    private StartPage inputDropOffDate(String date) {
        dropOffDate.clear();
        dropOffDate.sendKeys(date);
        LOGGER.info("DropOffDate was sended");
        return this;
    }

    public boolean isErrorMessageVisible(WebDriver driver) {
        WebElement errorMessage =
                new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"c2O1F-dialog-body\"]/div")));
        return errorMessage.isDisplayed();
    }


    public StartPage pickUpTimeIsBeforeTheCurrentTime(String pickUpPlace, String pickUpDate, String dropOffDate) {
        inputPickUpPlace(pickUpPlace);
        inputPickUpDate(pickUpDate);
        inputDropOffDate(dropOffDate);
        searchCar();
        return this;
    }

    public StartPage searchWithWrongPickUpField(String WrongPickUpPlace, String pickUpDate) {
        inputPickUpPlace(WrongPickUpPlace);
        inputPickUpDate(pickUpDate);
        inputDropOffDate(pickUpDate);
        searchCar();
        return this;
    }

    public StartPage searchWithEmptyPickUpField(String EmptyPickUpPlace, String pickUpDate,String dropOffDate) {
        inputPickUpPlace(EmptyPickUpPlace);
        inputPickUpDate(pickUpDate);
        inputDropOffDate(dropOffDate);
        searchCar();
        return this;
    }

}
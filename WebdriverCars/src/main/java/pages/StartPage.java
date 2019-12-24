package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Car;
import model.PageError;
import model.Account;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class StartPage extends AbstractPage{
    private final String PAGE_URL = "https://www.kayak.com/horizon/sem/cars/general";
    private final Logger LOGGER = LogManager.getRootLogger();
    private final int WAIT_TIMEOUT_SECONDS = 3;


    WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS);


    @FindBy(className = "_iiN _ial _iNI _iaL _idj _iyq _iaj _ieK")
    private WebElement OpenSignIn;

    @FindBy(className = "_i2B _i2C _h-8 _iAx _ikD Button-No-Standard-Style")
    private WebElement registerChange;

    @FindBy(id = "OLt7-username")
    private WebElement registerEmail;

    @FindBy(id = " OLt7-password")
    private WebElement registerPassword;

    @FindBy(id = " OLt7-submit")
    private WebElement registerSubmit;

    @FindBy(id = " Vs8a-error-message")
    private WebElement errorRegisterMessage;

    @FindBy(id = "c2aL9-pickup")
    private WebElement pickUpPlace;

    @FindBy(id = "c2aL9-dropoff-date-input")
    private WebElement dropOffPlace;

    @FindBy(id = "c2aL9-pickup-date-input")
    private WebElement pickUpDate;

    @FindBy(xpath = "//*[@id=\"uO2g-dateRangeInput-display-end-inner\"]")
    private WebElement dropOffDate;

    @FindBy(xpath = "//*[@id=\"uO2g-dateRangeInput-start-time\"]")
    private WebElement pickUpTime;

    @FindBy(className = "//*[@id=\"c3RGs-messages\"]")
    private WebElement placeError;

    @FindBy(className= "_iaf _iam _ian _iai")
    private WebElement loginSuccess;

    @FindBy(xpath = "//*[@id=\"ZZsn-submit\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"TCe_-username\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"TCe_-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"TCe_-submit\"]")
    private WebElement loginSubmitButton;

    @FindBy(id = "c7hCm-error-message")
    private WebElement errorLogin;

    @FindBy(className = "_iaB _it _iH1")
    private WebElement noCars;

    @FindBy(id = "PXe0-switch-display-status")
    private WebElement choosePlace;

    @FindBy(id = "PXe0-switch-option-2")
    private WebElement diffplace;

    @FindBy(id = "F5Bn")
    private WebElement mainpage;



    public StartPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    @Override
    public StartPage openPage() {
        webDriver.get(PAGE_URL);

        LOGGER.info("Page was opened");
       // webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }


    private void searchCar() {
        searchButton.click();
        LOGGER.info("Searching...");
    }

    private StartPage selectPickUpTime(String picTime) {
        new Select(pickUpTime);
        LOGGER.info("Selected time");
        return this;
    }

    public boolean checkPlaceErrorMessage(PageError error) {
        return true;
    }

    public boolean checkPlaceLoginErrorMessage(PageError error){
        return errorLogin.isDisplayed()
                && errorLogin.getText().
                contains(error.getErrorDescription());
    }
    public boolean checkPlaceRegisterErrorMessage(PageError error){
        return errorRegisterMessage.isDisplayed()
                && errorRegisterMessage.getText().
                contains(error.getErrorDescription());
    }

    public StartPage inputData(Car car){
        LOGGER.info("Try to input");
        return this;
    }

    public StartPage inputRegisterData(Account account){
        if(registerChange.isDisplayed()) {
            registerChange.click();
            LOGGER.info("Change to register");
        }
        registerEmail.clear();
        registerEmail.sendKeys(account.getEmail());
        LOGGER.info("Filled email ");
        registerPassword.clear();
        registerPassword.sendKeys(account.getPassword());
        LOGGER.info("Filled password");
        registerSubmit.click();
        LOGGER.info("Register performed");
        return this;
    }

    public StartPage inputDataAccount(Account account){
        emailInput.clear();
        emailInput.sendKeys(account.getEmail());
        LOGGER.info("Filled email");
        passwordInput.clear();
        passwordInput.sendKeys(account.getPassword());
        LOGGER.info("Filled password");
        loginSubmitButton.click();
        LOGGER.info("Login performed");
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

    public boolean isLoginSuccess(){
        return loginSuccess.isDisplayed();
    }
    public boolean isNoCarsSuccess(PageError error){
      return noCars.isDisplayed()
                && noCars.getText().
                contains(error.getErrorDescription());
    }



}
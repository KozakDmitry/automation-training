package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.CarRent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Car;
import model.PageError;
import model.Account;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class SearchCarPage extends AbstractPage{
    private final String PAGE_URL = "https://www.kayak.com/cars/Minsk-c9524/2019-12-17/2019-12-18;map?sort=rank_a&fs=caragency=~avis";
    private final Logger LOGGER = LogManager.getRootLogger();
    private final int WAIT_TIMEOUT_SECONDS = 15;
    private final String TESTDATA_CASE910_XPATH = "testdata.case9-10.carxpath";


    @FindBy(className = "_id7 _iMl _ia1 _irc _iQB _h-Y _iai")
    private WebElement KayakCar;
    @FindBy(xpath = "//*[@id=\"disabledBookButton\"]")
    private WebElement errorMessage;
    @FindBy(className = "radioOption")
    private WebElement inputIns;
    @FindBy(xpath = TESTDATA_CASE910_XPATH)
    private WebElement neededCar;
    @FindBy(className = "travelers[0].firstName")
    private WebElement name;
    @FindBy(className = "travelers[0].lastName")
    private WebElement lastname;
    @FindBy(className = "travelers[0].emailAddress")
    private WebElement email;
    @FindBy(className = "travelers[0].shortPhoneNumber")
    private WebElement phone;
    @FindBy(className = "cc[0].cc_name")
    private WebElement nameOfCard;
    @FindBy(className = "cc[0].cc_number")
    private WebElement numCard;
    @FindBy(className = "cc[0].cc_expires")
    private WebElement expDate;
    @FindBy(className = "cc[0].cc_securitycode")
    private WebElement CVV;
    @FindBy(className = "cc[0].billing_streetaddress1")
    private WebElement address;
    @FindBy(className = "Checkout-Common-Uicore-SimpleButton Button-Dark Button-Disabled fullWidth")
    private WebElement Submit;


    public SearchCarPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    @Override
    public SearchCarPage openPage() {
        webDriver.get(PAGE_URL);
        LOGGER.info("Page was opened");
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }

    public SearchCarPage OpenCar(){
        neededCar.click();
        LOGGER.info("Page with car opened");
        return this;
    }

    public boolean checkPlaceErrorMessage(PageError error) {
        return errorMessage.isDisplayed()
                && errorMessage.getText().
                contains(error.getErrorDescription());
    }

    public SearchCarPage InputDataPerson(CarRent carRent){
        name.clear();
        name.sendKeys(carRent.getName());
        LOGGER.info("Filled Name");
        lastname.clear();
        lastname.sendKeys(carRent.getLastName());
        LOGGER.info("Filled LastName");
        email.clear();
        email.sendKeys(carRent.getEmail());
        LOGGER.info("Filled email");
        phone.clear();
        phone.sendKeys(carRent.getPhone());
        LOGGER.info("Filled Phone");
        inputIns.click();
        LOGGER.info("Selected WithInsurance");
        Submit.click();
        LOGGER.info("Try to submit");
        return this;
    }
}

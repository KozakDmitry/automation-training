package service;

import model.Car;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarCreator {
    private static final String TESTDATA_CASE_1_PLACE_FROM = "testdata.case1.place-from";
    private static final String TESTDATA_CASE_1_PLACE_TO = "testdata.case1.place-to";
    private static final String TESTDATA_CASE_1_PICK_UP_PLUS_DAYS = "testdata.case1.pick-up.plus-days";
    private static final String TESTDATA_CASE_1_RETURN_PLUS_DAYS = "testdata.case1.return.plus-days";

    private static final String TESTDATA_CASE_6_PLACE_FROM = "testdata.case6.place-from";
    private static final String TESTDATA_CASE_6_PLACE_TO = "testdata.case6.place-to";

    private static final String TESTDATA_CASE_7_PLACE_FROM = "testdata.case7.place-from";
    private static final String TESTDATA_CASE_7_PLACE_TO = "testdata.case7.place-to";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final LocalDate nowDate = LocalDate.now();


    public static Car withNegativeRentalPeriodFromProperty() {
        return (new Car())
                .setPickUpPlace(TestDataReader.getTestData(TESTDATA_CASE_1_PLACE_FROM))
                .setDropOffPlace(TestDataReader.getTestData(TESTDATA_CASE_1_PLACE_TO))
                .setpickUpDate(getDateStringWithPlusDays(TESTDATA_CASE_1_PICK_UP_PLUS_DAYS))
                .setdropOffDate(getDateStringWithPlusDays(TESTDATA_CASE_1_RETURN_PLUS_DAYS));
    }
    public static Car withDifferentContinets() {
        return (new Car())
                .setPickUpPlace(TestDataReader.getTestData(TESTDATA_CASE_6_PLACE_FROM))
                .setDropOffPlace(TestDataReader.getTestData(TESTDATA_CASE_6_PLACE_TO));
    }
    public static Car withImaginaryPlace() {
        return (new Car())
                .setPickUpPlace(TestDataReader.getTestData(TESTDATA_CASE_7_PLACE_FROM))
                .setDropOffPlace(TestDataReader.getTestData(TESTDATA_CASE_7_PLACE_TO));
    }


    public static Car withEmptyFields() {
        return (new Car());
    }

    private static LocalDate getDateWithPlusDays(String plusDaysParamName) {
        return CarCreator.nowDate.plusDays(Integer.parseInt(TestDataReader
                .getTestData(plusDaysParamName)));
    }

    private static String getDateString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    private static String getDateStringWithPlusDays(String plusDaysParamName) {
        return getDateString(getDateWithPlusDays(plusDaysParamName));
    }
}

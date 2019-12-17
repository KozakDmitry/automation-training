package service;

import model.CarRent;

public class CarRentCreator {

    private static final String TESTDATA_CASE910_NAME = "testdata.case910.name";
    private static final String TESTDATA_CASE910_LASTNAME = "testdata.case910.lastname";
    private static final String TESTDATA_CASE910_EMAIL = "testdata.case910.email";
    private static final String TESTDATA_CASE9_NUMBER = "testdata.case9.phone";
    private static final String TESTDATA_CASE10_NUMBER = "testdata.case10.phone";

    public static CarRent withoutCreditCard() {
        return (new CarRent(TESTDATA_CASE910_NAME, TESTDATA_CASE910_LASTNAME, TESTDATA_CASE910_EMAIL, TESTDATA_CASE9_NUMBER));
    }

    public static CarRent withWrongNumber() {
        return (new CarRent(TESTDATA_CASE910_NAME, TESTDATA_CASE910_LASTNAME, TESTDATA_CASE910_EMAIL, TESTDATA_CASE10_NUMBER));
    }
}

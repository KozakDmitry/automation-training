package service;
import model.PageError;
public class PageErrorCreator {
    private static final String TESTDATA_CASE_1_EXPECTED_MESSAGE = "testdata.case1.expected.message";
    private static final String TESTDATA_CASE_2_EXPECTED_MESSAGE = "testdata.case2.expected.message";
    private static final String TESTDATA_CASE_3_EXPECTED_MESSAGE = "testdata.case3.expected.message";
    private static final String TESTDATA_CASE_4_EXPECTED_MESSAGE = "testdata.case4.expected.message";
    private static final String TESTDATA_CASE_6_EXPECTED_MESSAGE = "testdata.case6.expected.message";
    private static final String TESTDATA_CASE_8_EXPECTED_MESSAGE = "testdata.case8.expected.message";
    private static final String TESTDATA_CASE_9_EXPECTED_MESSAGE = "testdata.case9.expected.message";
    private static final String TESTDATA_CASE_10_EXPECTED_MESSAGE = "testdata.case10.expected.message";

    public static PageError errorForNegativeRentalPeriodFromProperty() {
        return new PageError(TESTDATA_CASE_1_EXPECTED_MESSAGE);
    }

    public static PageError errorForEmptyFields() {
        return new PageError(TESTDATA_CASE_2_EXPECTED_MESSAGE);
    }

    public static PageError errorLoginForEmptyFields() {
        return new PageError(TESTDATA_CASE_3_EXPECTED_MESSAGE);
    }

    public static PageError errorLoginWithNotRegisteredEmail(){
        return new PageError(TESTDATA_CASE_4_EXPECTED_MESSAGE);
    }
    public static PageError errorForNoCars(){
        return new PageError(TESTDATA_CASE_6_EXPECTED_MESSAGE);
    }
    public static PageError errorWithWrongEmail(){
        return new PageError(TESTDATA_CASE_8_EXPECTED_MESSAGE);
    }
    public static PageError errorWithoutCreditCard() {
        return new PageError(TESTDATA_CASE_9_EXPECTED_MESSAGE);
    }
    public static PageError errorWithWrongNumber() {
        return new PageError(TESTDATA_CASE_10_EXPECTED_MESSAGE);
    }



}

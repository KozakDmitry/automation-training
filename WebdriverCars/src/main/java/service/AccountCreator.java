package service;

import model.Account;


public class AccountCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.account.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.account.password";
    public static final String TESTDATA_USER_EMAIL_CASE4 = "testdata.case4.email";
    public static final String TESTDATA_USER_PASSWORD_CASE4 = "testdata.case4.password";
    public static final String TESTDATA_USER_EMAIL_CASE5 = "testdata.case5.email";
    public static final String TESTDATA_USER_PASSWORD_CASE5 = "testdata.case5.password";
    public static final String TESTDATA_USER_EMAIL_CASE8 = "testdata.case8.email";
    public static final String TESTDATA_USER_PASSWORD_CASE8 = "testdata.case8.password";

    public static Account withEmptyFields(){
        return (new Account());
    }

    public static Account withNotRegisteredEmail(){
        return (new Account(TESTDATA_USER_EMAIL_CASE4,TESTDATA_USER_PASSWORD_CASE4));
    }

    public static Account withRegisteredEmail(){
        return (new Account(TESTDATA_USER_EMAIL_CASE5,TESTDATA_USER_PASSWORD_CASE5));
    }

    public static Account withWrongEmail(){
        return (new Account(TESTDATA_USER_EMAIL_CASE8,TESTDATA_USER_PASSWORD_CASE8));
    }

}

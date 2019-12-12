package service;

import model.Account;


public class AccountCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.account.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.account.password";

    public static Account withCredentialsFromProperty(){
        return new Account(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static Account withEmptyEmail(){
        return new Account("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static Account withEmptyPassword(){
        return new Account(TestDataReader.getTestData(TESTDATA_USER_EMAIL), "");
    }
}

package com.spring.schoolapplication.utils;

public class CommonTestUtils {

    protected String restURL;
    protected DatabaseConnector databaseConnector;

    public CommonTestUtils(String restURL, DatabaseConnector databaseConnector) {
        this.restURL = restURL;
        this.databaseConnector = databaseConnector;
    }
}

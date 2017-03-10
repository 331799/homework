package com.homework.test.api;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class ApiBasicTestCase {

    @BeforeClass
    public void setUp(){
        baseURI = "https://www.mybookingpal.com";
        basePath = "/xml/services/json";
    }
}

package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVeriable.path;
import static constants.Constants.RunVeriable.server;

public class TestConfig {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RequestSpecification requestSpecificationForUdemiCourse = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addCookie("testCookie")
                .build();

        RestAssured.requestSpecification = requestSpecificationForUdemiCourse;
    }
}

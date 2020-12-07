package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVeriable.path;
import static constants.Constants.RunVeriable.server;
import static constants.Constants.Servers.REQUESTBIN_URL;

public class TestConfig {



    protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/xml; charset=UTF-8")
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addCookie("testCookieJSON")
                .build();

        RestAssured.requestSpecification = requestSpecificationJson;

    }
}

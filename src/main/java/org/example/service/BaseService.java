package org.example.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.utility.FrameworkUtility;
import org.example.utility.ReadableResponse;

import static io.restassured.RestAssured.given;

public class BaseService extends FrameworkUtility {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String TRELLO_SERVICE_URL = "https://api.trello.com/1/boards";

    private final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(TRELLO_SERVICE_URL)
            .setBasePath("/")
            .build();

    protected ReadableResponse getRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }



}

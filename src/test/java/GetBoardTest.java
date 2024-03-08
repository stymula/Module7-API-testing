
import org.example.pojoClasses.BoardResponse;
import org.example.utility.AllureLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class GetBoardTest extends BaseTest {

    @Test(description="To retrieve the details of Board")
    public void get_Board_by_id() {

        AllureLogger.logToAllure("Starting the test to get Board");
        String boardId = "65e999f9265427651c6f8c6e";

        //Sending the GET request for a specific board id and receiving the response
        AllureLogger.logToAllure("Getting the response for the Board Id");
        Response response = given().
                spec(requestSpec).
                pathParam("boardId", boardId).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                when().
                get("/{boardId}");

        //Verify the response code
        AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
        response.then().spec(responseSpec);

        //To log the response to report
        logResponseAsString(response);


        //Using the POJO class
        AllureLogger.logToAllure("Asserting the response body");

        BoardResponse boardResponse = response.as(BoardResponse.class);
        String name = "New-Test-Board";
        String desc = "Board created from Postman";

        Assert.assertEquals(boardResponse.getName(), name);
        Assert.assertEquals(boardResponse.getDesc(), desc);

    }
}
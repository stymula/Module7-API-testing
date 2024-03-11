
import org.example.pojoClasses.BoardResponse;
import org.example.utility.AllureLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class GetBoardTest extends BaseTest {

    @Test(description="Get Trello Board")
    public void get_board_by_id() {

        AllureLogger.logToAllure("Starting the test to get BOARD");

        AllureLogger.logToAllure("Sending the GET request for a BOARD and receiving the response");
        Response response = given().
                spec(requestSpec).
                pathParam("boardId", CreateBoardTest.newId).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                when().
                get("/{boardId}");

        AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
        response.then().spec(responseSpec);

        logResponseAsString(response);

        //Using the POJO class
        AllureLogger.logToAllure("Asserting the response body");

        BoardResponse boardResponse = response.as(BoardResponse.class);
        String name = "Test-Board-Created-with-Java";
        String desc = "Description from Java";

        Assert.assertEquals(boardResponse.getName(), name);
        Assert.assertEquals(boardResponse.getDesc(), desc);
    }
}
import io.restassured.response.Response;
import org.example.pojoClasses.BoardResponse;
import org.example.utility.AllureLogger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateBoardTest extends BaseTest{

    @Test(description="Update Trello Board")
    public void update_board(){

        AllureLogger.logToAllure("Starting the test to update BOARD");

        //Create a new Board
        CreateBoardTest newBoard = new CreateBoardTest();
        newBoard.create_board_with_name_and_description();
        String IDtoUpdate = CreateBoardTest.newId;
        AllureLogger.logToAllure("New Board Id created is : " +IDtoUpdate);

        //Update the Board with new name
        Response getResponse = given().
                spec(requestSpec).
                pathParam("boardId", IDtoUpdate).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                when().
                get("/{boardId}");

        BoardResponse boardDetails = getResponse.as(BoardResponse.class);
        boardDetails.setName("Updated Board with Java");

        AllureLogger.logToAllure("Sending the PUT request to update Board details of Board id : " + IDtoUpdate);
        Response response = given().
                spec(requestSpec).
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                pathParam("boardId", IDtoUpdate).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                body(boardDetails).log().body().
                when().
                put("/{boardId}");

        AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
        response.then().spec(responseSpec);

        logResponseAsString(response);
    }
}

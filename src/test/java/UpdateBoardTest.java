import io.restassured.response.Response;
import org.example.pojoClasses.BoardResponse;
import org.example.utility.AllureLogger;
import org.testng.annotations.Test;

public class UpdateBoardTest extends BaseTest{

    @Test(description="Update Trello Board")
    public void update_board(){

        AllureLogger.logToAllure("Starting the test to update BOARD");

        //Create a new Board
        CreateBoardTest newBoard = new CreateBoardTest();
        newBoard.create_board_with_name_and_description();
        String IDtoUpdate = CreateBoardTest.newId;
        AllureLogger.logToAllure("New Board Id created is : " +IDtoUpdate);

        //get Board with id and update Board
        Response getResponse = getRequest("/{boardId}", IDtoUpdate);
        BoardResponse boardDetails = getResponse.as(BoardResponse.class);
        boardDetails.setName("Updated Board with Java");

        AllureLogger.logToAllure("Sending the PUT request to update Board details of Board id : " + IDtoUpdate);
        Response response = putRequest(boardDetails, IDtoUpdate);

        AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
        response.then().spec(responseSpec);

        logResponseAsString(response);
    }
}

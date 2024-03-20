import io.restassured.response.Response;
import org.example.utility.AllureLogger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBoardTest extends BaseTest{
    @Test(description="Delete Trello Board")
    public void delete_board_by_id(){

        AllureLogger.info("Starting the test to delete BOARD");

        //Create a new Board, this will be subsequently deleted
        CreateBoardTest newBoard = new CreateBoardTest();
        newBoard.create_board_with_name_and_description();
        String IDtoDelete = CreateBoardTest.newId;
        AllureLogger.info("New Board ID created is : " + IDtoDelete);
        AllureLogger.info("Board ID to be deleted is : "+IDtoDelete);

        AllureLogger.info("Sending the DELETE request for specific ID and receiving the response");
        Response response = deleteRequest(IDtoDelete);

        AllureLogger.info("Asserting the response if the status code returned is 201 as this is a Delete request");
        response.then().spec(responseSpec);

        logResponseAsString(response);
    }
}

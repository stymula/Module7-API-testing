import io.restassured.response.Response;
import org.example.pojoClasses.BoardResponse;
import org.example.utility.AllureLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBoardTest extends BaseTest{

    public static String newId = "";

    @Test(description = "Create Trello Board")
    public void create_board_with_name_and_description() {
        AllureLogger.logToAllure("Starting the test to create new BOARD");

        BoardResponse boardDetails = new BoardResponse();
        boardDetails.setName("Test-Board-Created-with-Java");
        boardDetails.setDesc("Description from Java");

        AllureLogger.logToAllure("Sending the POST request to create new BOARD");
        Response response = postRequest(boardDetails);

        AllureLogger.logToAllure("Asserting if the response's status code returned is 200");
        response.then().spec(responseSpec);

        logResponseAsString(response);

        //Using the POJO class
        AllureLogger.logToAllure("Asserting the response body");

        BoardResponse boardResponse = response.as(BoardResponse.class);
        String name = "Test-Board-Created-with-Java";
        String desc = "Description from Java";

        Assert.assertEquals(boardResponse.getName(), name);
        Assert.assertEquals(boardResponse.getDesc(), desc);

        //Get newly created Id
        //System.out.println("Response Body: " + response.getBody().asString());
        newId = response.then().extract().path("id").toString();
        AllureLogger.logToAllure("Retrieved board id: " + newId);
    }
}

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.example.pojoClasses.BoardResponse;
import org.example.retrofit.TrelloApi;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetBoardRetrofitTest extends BaseTestRetrofit {
    String jsonPath = "src/test/resources/classes/Post/board-response.json";

    @Test(description = "'GET' test for 'Boards' endpoint")
    public void getBoardTest() throws JsonSyntaxException, IOException {
        // Get JSON Data from resources package to compare callSync with this
        BoardResponse board =
                new Gson().fromJson(new String(Files.readAllBytes(Paths.get(jsonPath))), BoardResponse.class);

        // Create a Retrofit Service with an Interface
        TrelloApi service = retrofit.create(TrelloApi.class);

        // Make API call with one of the methods defined in the interface
        Response<BoardResponse> callSync = service.getBoard(
                        "65f181012484390ae7d29b21",
                        "70b1875aedd8b3ab979bbf7666f76469",
                        "ATTA932c20c22cf8646383447b30bb1e58a261987aa3fa27f976976a9557c5d7c6b0D86FD831")
                .execute();

        String responseJson = new Gson().toJson(callSync.body()).toString();

        // Now you can make all assertions that you need in order to test target API functioning
//        Assert.assertNotEquals(callSync.body(), null, "Post is not working");
//        Assert.assertEquals(post.getId(), callSync.body().getId(), "Hey! This data is wrong!");
//        test.info("Getting info for post: " + callSync.body().getId());
//        // Also, you can send interest info to extentreport
//        test.info("This is the Response Body: " + responseJson);
//        Assert.assertEquals(callSync.code(), 200, "Expected 'OK' HTTP response code but found '" + callSync.code() + "'");
//        test.info("This is the Response HTTP code: " + callSync.code());
    }
}
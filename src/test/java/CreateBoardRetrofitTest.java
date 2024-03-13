import com.google.gson.Gson;
import org.example.pojoClasses.BoardResponse;
import org.example.retrofit.TrelloApi;
import org.testng.annotations.Test;
import retrofit2.Response;
import java.io.IOException;

public class CreateBoardRetrofitTest extends BaseTestRetrofit {

    public static String newId = "";
    public String jsonPath = "src/test/resources/classes/Board/board-response.json";

    @Test(description = "Create Trello Board with Retrofit")
    public void create_board_with_name_and_description() throws IOException {

        // Create a Retrofit Service with an Interface
        TrelloApi service = retrofit.create(TrelloApi.class);

        // Make API call with one of the methods defined in the interface
        Response<BoardResponse> callSync = service.createBoard(
                "new-name",
                "new-desc",
                readConfigurationFile("key"),
                readConfigurationFile("token"))
                .execute();

        String responseJson = new Gson().toJson(callSync.body()).toString();
    }
}


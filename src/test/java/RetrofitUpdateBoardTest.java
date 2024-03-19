import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import org.example.pojoClasses.BoardResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitUpdateBoardTest extends BaseTestRetrofit{

    @Test
    public void update_board() throws IOException {
        String key = readConfigurationFile("key");
        String token = readConfigurationFile("token");
        String boardId = RetrofitCreateBoardTest.newId;
        String newName = "Updated-Test-Board-Retrofit";

        BoardResponse request = new BoardResponse();
        request.setName(newName);

        Call<ResponseBody> call = service.updateBoard(boardId, request, key, token);
        Response<ResponseBody> response = call.execute();

        if (response.isSuccessful()){
            String responseBodyString = response.body().string();
            System.out.println(responseBodyString);

            Assert.assertEquals(response.code(), 200,
                    "Expected " + 200 + " HTTP response code but found '" + response.code() + "'");
            JsonObject jsonResponse = JsonParser.parseString(responseBodyString).getAsJsonObject();
            Assert.assertEquals(jsonResponse.get("name").getAsString(), newName);
        } else {
            System.err.println("HTTP request failed with code: " + response.code());
        }
    }
}

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitGetBoardTest extends BaseTestRetrofit{

    @Test
    public void get_board_by_id() throws IOException {
        String key = readConfigurationFile("key");
        String token = readConfigurationFile("token");
        String boardId = RetrofitCreateBoardTest.newId;

        Call<ResponseBody> call = service.getBoardById(boardId, key, token);
        Response<ResponseBody> response = call.execute();

        if (response.isSuccessful()){
            String responseBodyString = response.body().string();
            System.out.println(responseBodyString);

            Assert.assertEquals(response.code(), 200,
                    "Expected " + 200 + " HTTP response code but found '" + response.code() + "'");
            JsonObject jsonResponse = JsonParser.parseString(responseBodyString).getAsJsonObject();
            Assert.assertEquals(jsonResponse.get("id").getAsString(), boardId);
        } else {
            System.err.println("HTTP request failed with code: " + response.code());
        }
    }
}

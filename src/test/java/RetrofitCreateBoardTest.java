import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitCreateBoardTest extends BaseTestRetrofit{

    public static String newId = "";

    @Test
    public void create_board() throws IOException {

        String key = readConfigurationFile("key");
        String token = readConfigurationFile("token");
        String name = "New-Test-Board-Retrofit";
        String desc = "Board created with retrofit and OkHttp";

        Call<ResponseBody> call = service.createBoardWithNameAndDescription(name, desc, key, token);
        Response<ResponseBody> response = call.execute();

        if (response.isSuccessful()){
            String responseBodyString = response.body().string();
            System.out.println(responseBodyString);

            Assert.assertEquals(response.code(), 200,
                    "Expected " + 200 + " HTTP response code but found '" + response.code() + "'");

            JsonObject jsonResponse = JsonParser.parseString(responseBodyString).getAsJsonObject();
            newId = jsonResponse.get("id").getAsString();
        } else {
            System.err.println("HTTP request failed with code: " + response.code());
        }

    }
}

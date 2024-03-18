import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.IOException;

public class RetrofitDeleteBoardTest extends BaseTestRetrofit{

    @Test
    public void delete_board() throws IOException {
        String key = readConfigurationFile("key");
        String token = readConfigurationFile("token");
        String boardId = RetrofitCreateBoardTest.newId;

        Call<ResponseBody> call = service.deleteBoard(boardId, key, token);
        retrofit2.Response<ResponseBody> response = call.execute();

        if (response.isSuccessful()){
            String responseBodyString = response.body().string();
            System.out.println(responseBodyString);

            Assert.assertEquals(response.code(), 200,
                    "Expected " + 200 + " HTTP response code but found '" + response.code() + "'");
        } else {
            System.err.println("HTTP request failed with code: " + response.code());
        }
    }
}

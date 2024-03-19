import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpGetBoardTest {

    private final OkHttpClient httpClient = new OkHttpClient();

    @Test
    public void get_board_by_id() throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.trello.com")
                .addPathSegment("1")
                .addPathSegment("boards")
                .addPathSegment("65f80c29449be8543f76b916") //boardId
                .addQueryParameter("key", "70b1875aedd8b3ab979bbf7666f76469")
                .addQueryParameter("token", "ATTA932c20c22cf8646383447b30bb1e58a261987aa3fa27f976976a9557c5d7c6b0D86FD831")
                .build();

        System.out.println(httpUrl.toString());

        Request requestHttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        try (Response response = httpClient.newCall(requestHttp).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }

    }

}

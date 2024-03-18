import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpDeleteBoardTest extends BaseTestHttp {
    @Test
    public static void delete_board_by_id() throws IOException, URISyntaxException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpDelete delete = getHttpDelete();
            System.out.println("Executing request " + delete.getRequestLine());

            CloseableHttpResponse response = httpClient.execute(delete);

            int statusCode = response.getStatusLine().getStatusCode();
            org.junit.Assert.assertEquals(statusCode, 200);
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        }

    }
}

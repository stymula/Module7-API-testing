import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpCreateBoardTest extends BaseTestHttp{

    public static String newId = "";

    @Test
    public void create_board_with_name_and_description() throws URISyntaxException {

        HttpPost post = getHttpPost();
        System.out.println("Executing request " + post.getRequestLine());

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            int statusCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals(statusCode, 200);
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JSONObject jsonObject = new JSONObject(result);
                Assert.assertEquals(jsonObject.getString("name"), "Test-Board-Http");
                Assert.assertTrue("Board description doesn't match", result.contains("Created with ApacheHttp"));
                System.out.println(result);

                newId = jsonObject.getString("id");
            }

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException occurred: " + e.getMessage());
        }

    }
}
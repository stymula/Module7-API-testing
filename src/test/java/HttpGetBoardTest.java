import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpGetBoardTest extends BaseTestHttp{

    @Test
    public void get_board_by_id() throws URISyntaxException {

        HttpGet get = getHttpGet();
        System.out.println("Executing request " + get.getRequestLine());

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)) {

            int statusCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals(statusCode, 200);
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Assert.assertTrue("Board name doesn't match", result.contains("Test-Board-Http"));
                System.out.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException occurred: " + e.getMessage());
        }

    }

}
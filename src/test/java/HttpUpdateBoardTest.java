import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpUpdateBoardTest extends BaseTestHttp {

    @Test
    public void update_board() throws URISyntaxException {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpPut put = getHttpPut();

            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Updated-Test-Board-Http");

            // Set the request body
            StringEntity requestEntity = new StringEntity(requestBody.toString());
            put.setEntity(requestEntity);

            System.out.println("Executing request " + put.getRequestLine());

            ResponseHandler< String > responseHandler = res -> {
            int status = res.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = res.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            String responseBody = httpClient.execute(put, responseHandler);
            System.out.println(responseBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;

public class BaseTestHttp {

    protected static HttpGet getHttpGet() throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder("https://api.trello.com/1/boards/" + HttpCreateBoardTest.newId);
        uriBuilder.addParameter("key", "70b1875aedd8b3ab979bbf7666f76469");
        uriBuilder.addParameter("token", "ATTA932c20c22cf8646383447b30bb1e58a261987aa3fa27f976976a9557c5d7c6b0D86FD831");

        HttpGet get = new HttpGet(uriBuilder.build());

        get.addHeader("Content-Type", "application/json");
        return get;
    }

    protected static HttpPost getHttpPost() throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder("https://api.trello.com/1/boards/");
        uriBuilder.addParameter("name", "Test-Board-Http");
        uriBuilder.addParameter("desc", "Created with ApacheHttp");
        uriBuilder.addParameter("key", "70b1875aedd8b3ab979bbf7666f76469");
        uriBuilder.addParameter("token", "ATTA932c20c22cf8646383447b30bb1e58a261987aa3fa27f976976a9557c5d7c6b0D86FD831");

        HttpPost post = new HttpPost(uriBuilder.build());

        post.addHeader("Content-Type", "application/json");
        return post;
    }

    protected static HttpPut getHttpPut() throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder("https://api.trello.com/1/boards/" + HttpCreateBoardTest.newId);
        uriBuilder.addParameter("key", "70b1875aedd8b3ab979bbf7666f76469");
        uriBuilder.addParameter("token", "ATTA932c20c22cf8646383447b30bb1e58a261987aa3fa27f976976a9557c5d7c6b0D86FD831");

        HttpPut put = new HttpPut(uriBuilder.build());

        put.setHeader("Accept", "application/json");
        put.setHeader("Content-type", "application/json");
        return put;
    }

    protected static HttpDelete getHttpDelete() throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder("https://api.trello.com/1/boards/" + HttpCreateBoardTest.newId);
        uriBuilder.addParameter("key", "70b1875aedd8b3ab979bbf7666f76469");
        uriBuilder.addParameter("token", "ATTA932c20c22cf8646383447b30bb1e58a261987aa3fa27f976976a9557c5d7c6b0D86FD831");

        HttpDelete delete = new HttpDelete(uriBuilder.build());

        return delete;
    }
}

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.pojoClasses.BoardResponse;
import org.example.utility.AllureLogger;
import org.example.utility.FrameworkUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;


public abstract class BaseTest extends FrameworkUtility {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    protected Response getRequest(String endPoint, String boardId) {
        return  given().
                spec(requestSpec).
                header(CONTENT_TYPE, APPLICATION_JSON).
                pathParam("boardId", boardId).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                when().
                get(endPoint);
    }

    protected Response postRequest(BoardResponse boardDetails) {
        return  given().
                spec(requestSpec).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                contentType(APPLICATION_JSON).
                body(boardDetails).log().body().
                when().
                post("/");
    }

    protected Response putRequest(BoardResponse boardDetails, String IDtoUpdate) {
        return  given().
                spec(requestSpec).
                header(CONTENT_TYPE, APPLICATION_JSON).
                header("Accept", APPLICATION_JSON).
                pathParam("boardId", IDtoUpdate).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                body(boardDetails).log().body().
                when().
                put("/{boardId}");
    }

    protected Response deleteRequest(String IDtoDelete) {
        return  given().
                spec(requestSpec).
                header(CONTENT_TYPE, APPLICATION_JSON).
                queryParam("key", readConfigurationFile("key")).
                queryParam("token", readConfigurationFile("token")).
                pathParam("boardId", IDtoDelete).
                when().
                delete("/{boardId}");
    }

    @BeforeSuite
    public void setBaseURI() {

        AllureLogger.info("The base URI is : " + readConfigurationFile("Base_URI"));
        requestSpec = new RequestSpecBuilder().
                setBaseUri(readConfigurationFile("Base_URI")).build();

    }

    @BeforeMethod
    public void beforeMethod() {
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
    }

}
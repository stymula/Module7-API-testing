import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.utility.AllureLogger;
import org.example.utility.FrameworkUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest extends FrameworkUtility {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeSuite
    public void setBaseURI() {

        AllureLogger.logToAllure("The base URI is : " + readConfigurationFile("Base_URI"));
        requestSpec = new RequestSpecBuilder().
                setBaseUri(readConfigurationFile("Base_URI")).build();

    }

    /****************************************************************************************************************/
//	@BeforeClass
    public void beforeClass() {
    }

    /****************************************************************************************************************/
//	@AfterClass
    public void afterClass(){

    }

    /************************************************************************************************************************/
    @BeforeMethod
    public void beforeMethod() {
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    //	@AfterMethod
    public void afterMethod() {

    }

}
/*****************************************************************************************************************/
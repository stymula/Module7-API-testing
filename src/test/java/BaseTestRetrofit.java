import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.example.utility.FrameworkUtility;
import org.testng.annotations.BeforeMethod;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseTestRetrofit extends FrameworkUtility {

    protected OkHttpClient.Builder httpClient;
    protected static Retrofit retrofit;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        // HTTP Client creation
        httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl(readConfigurationFile("Base_URI") + "/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .client(httpClient.build())
                .build();
    }
}


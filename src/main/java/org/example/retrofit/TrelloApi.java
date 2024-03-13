package org.example.retrofit;
import org.example.pojoClasses.BoardResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {

    @POST("/")
    @Headers("Content-Type: application/json")
    Call<BoardResponse> createBoard(@Query("name") String name,
                                    @Query("desc") String desc,
                                    @Query("key") String key,
                                    @Query("token") String token);

    @GET("/{boardId}")
    Call<BoardResponse> getBoard(
            @Path("boardId") String boardId,
            @Query("key") String key,
            @Query("token") String token);

}
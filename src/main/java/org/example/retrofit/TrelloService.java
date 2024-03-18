package org.example.retrofit;
import okhttp3.ResponseBody;
import org.example.pojoClasses.BoardResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloService {

    @POST("/1/boards/")
    Call<ResponseBody> createBoardWithNameAndDescription(
            @Query("name") String name,
            @Query("desc") String desc,
            @Query("key") String key,
            @Query("token") String token
    );

    @GET("/1/boards/{boardId}")
    Call<ResponseBody> getBoardById(
            @Path("boardId") String boardId,
            @Query("key") String key,
            @Query("token") String token
    );

    @PUT("/1/boards/{boardId}")
    Call<ResponseBody> updateBoard(
            @Path("boardId") String boardId,
            @Body BoardResponse newBoard,
            @Query("key") String key,
            @Query("token") String token
    );

    @DELETE("/1/boards/{boardId}")
    Call<ResponseBody> deleteBoard(
            @Path("boardId") String boardId,
            @Query("key") String key,
            @Query("token") String token
    );
}
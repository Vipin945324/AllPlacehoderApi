package digi.coders.allplacehoderapi;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServies {

    @GET ("posts")
    Call<JsonArray>getPost();

    @GET("posts/{id}/comments")
    Call<JsonArray>getComments(
            @Path("id")String id
    );

    @GET("comment/{id}/albums")
    Call<JsonArray>getAlbums(
            @Path("id")String id
    );
}

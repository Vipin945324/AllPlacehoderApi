package digi.coders.allplacehoderapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static ApiServies getClient(){
        Retrofit retrofit=new Retrofit
                .Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServies apiServies=retrofit.create(ApiServies.class);
        return apiServies;
    }
}

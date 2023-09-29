package digi.coders.allplacehoderapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView postRecycler;
    List<PostModel>postModelList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postRecycler=findViewById(R.id.postRecycler);

        RetrofitClient.getClient().getPost().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    JsonArray jsonArray=response.body().getAsJsonArray();
                    for (int i=0; i<jsonArray.size(); i++){
                        JsonObject jsonObject=jsonArray.get(i).getAsJsonObject();
                        PostModel postModel=new Gson().fromJson(jsonObject,PostModel.class);
                        postModelList.add(postModel);
                    }

                    PostAdapter postAdapter=new PostAdapter(MainActivity.this,postModelList);
                    postRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
                    postRecycler.setAdapter(postAdapter);
                }
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}
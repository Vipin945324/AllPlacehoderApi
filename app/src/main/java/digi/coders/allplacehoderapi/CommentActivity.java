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

public class CommentActivity extends AppCompatActivity {

    RecyclerView commentsRecycler;
    List<CommentModel>commentModelList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commentsRecycler=findViewById(R.id.CommentRecycler);

        int userId=getIntent().getIntExtra("userId",0);

        RetrofitClient.getClient().getComments("1").enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful()){
                    Toast.makeText(CommentActivity.this, "comments Api success", Toast.LENGTH_SHORT).show();
                    JsonArray jsonArray=response.body().getAsJsonArray();
                    for (int i=0; i<jsonArray.size(); i++){
                        JsonObject jsonObject=jsonArray.get(i).getAsJsonObject();
                        CommentModel commentModel=new Gson().fromJson(jsonObject,CommentModel.class);
                        commentModelList.add(commentModel);
                    }

                    CommentAdapter commentAdapter=new CommentAdapter(CommentActivity.this,commentModelList);
                    commentsRecycler.setLayoutManager(new LinearLayoutManager(CommentActivity.this,RecyclerView.VERTICAL,false));
                    commentsRecycler.setAdapter(commentAdapter);
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}
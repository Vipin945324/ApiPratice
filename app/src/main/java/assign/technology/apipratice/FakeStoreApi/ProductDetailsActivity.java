package assign.technology.apipratice.FakeStoreApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import assign.technology.apipratice.R;
import assign.technology.apipratice.RetrofitClient.RetrofitClient;
import assign.technology.apipratice.databinding.ActivityProductDetailsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {

    ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductDetailsBinding.inflate(getLayoutInflater());
        View viewBinding=binding.getRoot();
        setContentView(viewBinding);

        Intent intent=getIntent();
        int productId=intent.getIntExtra("ProductId",0);
        RetrofitClient.getClient().getProductDetails(productId).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    JsonObject jsonObject=response.body();
                    binding.productDetailId.setText(String.valueOf(jsonObject.get("id")));
                    binding.productDetailCategory.setText(jsonObject.get("category").getAsString());
                    binding.productDetailDescription.setText(jsonObject.get("description").getAsString());
                    binding.productDetailTitle.setText(jsonObject.get("title").getAsString());
                    Picasso.get().load(jsonObject.get("image").getAsString()).into(binding.productDetailImages);
                    binding.productDetailPrice.setText(String.valueOf(jsonObject.get("price").getAsFloat()));
                    binding.productDetailRating.setRating(jsonObject.getAsJsonObject("rating").get("rate").getAsFloat());
                    Toast.makeText(ProductDetailsActivity.this, "Success"+response.body().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ProductDetailsActivity.this, "Api Error Body"+response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "onFailure"+t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
    }
}
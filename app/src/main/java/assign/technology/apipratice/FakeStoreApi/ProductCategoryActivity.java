package assign.technology.apipratice.FakeStoreApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import assign.technology.apipratice.R;
import assign.technology.apipratice.RetrofitClient.RetrofitClient;
import assign.technology.apipratice.databinding.ActivityProductCategoryBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductCategoryActivity extends AppCompatActivity {
    ArrayList<AllProductModel> allProductModelArrayList=new ArrayList<>();
    ActivityProductCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductCategoryBinding.inflate(getLayoutInflater());
        View bindingView=binding.getRoot();
        setContentView(bindingView);

        Intent intent=getIntent();
        String Category =intent.getStringExtra("CategoryName");
        RetrofitClient.getClient().getProduct(Category).enqueue(new Callback<ArrayList<AllProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AllProductModel>> call, Response<ArrayList<AllProductModel>> response) {
                if (response.isSuccessful()){

                    allProductModelArrayList=response.body();
                    binding.productCategoryTypeRecycler.setLayoutManager(new GridLayoutManager(ProductCategoryActivity.this, 2));
                    binding.productCategoryTypeRecycler.setAdapter(new ProductAdapter(ProductCategoryActivity.this, allProductModelArrayList));

                }else {
                    Toast.makeText(ProductCategoryActivity.this, "Api Error Body"+response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AllProductModel>> call, Throwable t) {
                Toast.makeText(ProductCategoryActivity.this, "on Failure"+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("sdms", "onFailure: "+t.getMessage());
            }
        });
    }
}
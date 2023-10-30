package assign.technology.apipratice.FakeStoreApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import assign.technology.apipratice.R;
import assign.technology.apipratice.RetrofitClient.RetrofitClient;
import assign.technology.apipratice.databinding.ActivityAllProductBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllProductActivity extends AppCompatActivity {

    ActivityAllProductBinding binding;

    ArrayList<AllProductModel> allProductModelArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllProductBinding.inflate(getLayoutInflater());
        View bindingView=binding.getRoot();
        setContentView(bindingView);

        RetrofitClient.getClient().getAllProduct().enqueue(new Callback<ArrayList<AllProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AllProductModel>> call, Response<ArrayList<AllProductModel>> response) {
                if (response.isSuccessful()){

                    allProductModelArrayList=response.body();
                    binding.productRecyclerView.setLayoutManager(new GridLayoutManager(AllProductActivity.this, 2));
                    binding.productRecyclerView.setAdapter(new ProductAdapter(AllProductActivity.this, allProductModelArrayList));

                    Toast.makeText(AllProductActivity.this, "Success"+response.body().toString(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(AllProductActivity.this, "Api Error Body"+response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AllProductModel>> call, Throwable t) {
                Toast.makeText(AllProductActivity.this, "on Failure"+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("sdms", "onFailure: "+t.getMessage());
            }
        });
    }
}
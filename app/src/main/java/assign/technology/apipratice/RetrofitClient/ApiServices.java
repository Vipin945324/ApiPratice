package assign.technology.apipratice.RetrofitClient;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import assign.technology.apipratice.FakeStoreApi.AllProductModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("/products")
    Call<ArrayList<AllProductModel>>getAllProduct();
}

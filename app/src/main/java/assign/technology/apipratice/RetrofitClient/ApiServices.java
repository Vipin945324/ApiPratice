package assign.technology.apipratice.RetrofitClient;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import assign.technology.apipratice.FakeStoreApi.AllProductModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("/products")
    Call<ArrayList<AllProductModel>>getAllProduct();

    @GET("/products/{id}")
    Call<JsonObject>getProductDetails(
            @Path("id")int id
    );

    @GET("/products/categories")
    Call<JsonArray>getProductCategory();

    @GET("/products/category/{jewelery}")
    Call<JsonArray>getProduct();
}

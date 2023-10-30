package assign.technology.apipratice.FakeStoreApi;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import assign.technology.apipratice.MainActivity;
import assign.technology.apipratice.databinding.ProductItemlistBinding;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyProductViewHolder> {
    Context context;
    ArrayList<AllProductModel> productModelList;

    public ProductAdapter(Context context, ArrayList<AllProductModel> productModelList) {
        this.context = context;
        this.productModelList = productModelList;
    }

    @NonNull
    @Override
    public ProductAdapter.MyProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductItemlistBinding binding = ProductItemlistBinding.inflate(inflater, parent, false);
        return new MyProductViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyProductViewHolder holder, int position) {

        AllProductModel allProductModel = productModelList.get(position);
        holder.binding.productId.setText(String.valueOf(allProductModel.getId()));
        holder.binding.productTitle.setText(String.valueOf(allProductModel.getTitle()));
        holder.binding.productCategory.setText(allProductModel.getCategory());
        holder.binding.productRating.setRating(allProductModel.getRating());
        holder.binding.productPrice.setText("Price "+allProductModel.getPrice());
        holder.binding.productDescription.setText(allProductModel.getDescription());
        String productImageUrl = allProductModel.getImage();
        Picasso.get().load(productImageUrl).into(holder.binding.productImages);

        int id=allProductModel.getId();

        holder.binding.productCardView.setOnClickListener(view -> {
             Intent  intent=new Intent(context, ProductDetailsActivity.class);
             intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             intent.putExtra("ProductId",id);
             context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public static class MyProductViewHolder extends RecyclerView.ViewHolder {

        private final ProductItemlistBinding binding;

        public MyProductViewHolder(@NonNull ProductItemlistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

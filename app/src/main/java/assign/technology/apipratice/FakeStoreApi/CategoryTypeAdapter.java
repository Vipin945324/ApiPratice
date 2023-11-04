package assign.technology.apipratice.FakeStoreApi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import assign.technology.apipratice.R;
import retrofit2.Callback;

public class CategoryTypeAdapter extends RecyclerView.Adapter<CategoryTypeAdapter.MyCategoryTypeViewHolder> {
    Context context;
    ArrayList<Category> stringArrayList;

    public CategoryTypeAdapter(Context context, ArrayList<Category> stringArrayList) {
        this.context = context;
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public CategoryTypeAdapter.MyCategoryTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyCategoryTypeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_type_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryTypeAdapter.MyCategoryTypeViewHolder holder, int position) {
        Category category=stringArrayList.get(position);
        holder.textView.setText(category.getCategory());
        holder.CategoryImage.setImageResource(R.drawable.ic_launcher_background);

        holder.categoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ProductCategoryActivity.class);
                intent.putExtra("CategoryName",category.getCategory());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public class MyCategoryTypeViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView CategoryImage;
        MaterialCardView categoryCardView;

        public MyCategoryTypeViewHolder(@NonNull View itemView) {

            super(itemView);
            textView=itemView.findViewById(R.id.textCategory);
            CategoryImage=itemView.findViewById(R.id.CategoryImage);
            categoryCardView=itemView.findViewById(R.id.categoryCardView);

        }
    }
}

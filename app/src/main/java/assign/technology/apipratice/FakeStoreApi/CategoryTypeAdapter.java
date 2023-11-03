package assign.technology.apipratice.FakeStoreApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import assign.technology.apipratice.R;
import retrofit2.Call;

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

    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public class MyCategoryTypeViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyCategoryTypeViewHolder(@NonNull View itemView) {

            super(itemView);

        }
    }
}

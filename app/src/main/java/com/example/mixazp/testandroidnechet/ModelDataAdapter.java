package com.example.mixazp.testandroidnechet;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mixazp.testandroidnechet.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ModelDataAdapter extends RecyclerView.Adapter<ModelDataAdapter.ModelDataViewHolder> {

    private List<Product> model;
    private SQLiteDatabase db;
    private Cursor cursor;
    private Context context;
    private SQLiteConnector connector;

    public ModelDataAdapter(Context context, List<Product> models) {
        this.model = new ArrayList<>();
        this.model = models;
        this.context = context;
    }

    @Override
    public ModelDataAdapter.ModelDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item, parent, false);

        return new ModelDataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ModelDataAdapter.ModelDataViewHolder holder, int position) {
        holder.tvID.setText(Integer.toString(model.get(position).getId()));
        holder.tvName.setText(model.get(position).getName());
        holder.tvPrice.setText(Double.toString(model.get(position).getPrice()) );
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ModelDataViewHolder extends RecyclerView.ViewHolder{
        TextView tvID;
        TextView tvName;
        TextView tvPrice;

        public ModelDataViewHolder(View itemView) {
            super(itemView);

            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}

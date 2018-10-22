package com.dany.android.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dany.android.myapplication.R;
import com.dany.android.myapplication.modul.SoldoutResponse;

import java.util.List;

public class RvSoldoutAdapter extends RecyclerView.Adapter<RvSoldoutAdapter.SoldoutViewHolder> {

    private final List<SoldoutResponse> soldoutResponseList;
    private Activity activity;

    public RvSoldoutAdapter(List<SoldoutResponse> soldoutResponseList) {
        this.soldoutResponseList = soldoutResponseList;
    }

    @NonNull
    @Override
    public SoldoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_soldout,parent,false);
        return new SoldoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoldoutViewHolder holder, int position) {
        final SoldoutResponse soldoutResponse = soldoutResponseList.get(position);

        holder.tvName.setText(soldoutResponse.getNamaProduk());
    }

    @Override
    public int getItemCount() {
        return soldoutResponseList.size();
    }

    public class SoldoutViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public SoldoutViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_sold_name);
        }
    }
}

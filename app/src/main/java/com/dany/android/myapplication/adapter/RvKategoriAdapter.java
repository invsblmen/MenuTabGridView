package com.dany.android.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dany.android.myapplication.R;
import com.dany.android.myapplication.modul.KategoriResponse;

import java.util.List;

public class RvKategoriAdapter extends RecyclerView.Adapter<RvKategoriAdapter.KategoriViewHolder> {

    private final List<KategoriResponse> kategoriResponseList;
    private Activity activity;

    public RvKategoriAdapter(List<KategoriResponse> kategoriResponseList) {
        this.kategoriResponseList = kategoriResponseList;
    }

    @NonNull
    @Override
    public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_category, parent, false);
        return new KategoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriViewHolder holder, int position) {
        final KategoriResponse kategoriResponse = kategoriResponseList.get(position);

        holder.tvName.setText(kategoriResponse.getNamaKategori());
    }

    @Override
    public int getItemCount() {
        return kategoriResponseList.size();
    }

    public class KategoriViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public KategoriViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            tvName = itemView.findViewById(R.id.tv_kategory_name);
        }
    }
}

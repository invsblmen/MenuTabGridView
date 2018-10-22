package com.dany.android.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dany.android.myapplication.MainActivity;
import com.dany.android.myapplication.R;
import com.dany.android.myapplication.adapter.RvKategoriAdapter;
import com.dany.android.myapplication.adapter.RvSoldoutAdapter;
import com.dany.android.myapplication.modul.KategoriResponse;
import com.dany.android.myapplication.modul.SoldoutResponse;
import com.dany.android.myapplication.network.NetworkService;
import com.dany.android.myapplication.network.RestService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private static final String TAG = "Tes >>>>";
    private RecyclerView rvKategori, rvSoldout;
    private RvKategoriAdapter rvKategoriAdapterAdapter;
    private RvSoldoutAdapter rvSoldoutAdapter;
    private NetworkService mApiService;
    private List<KategoriResponse> listKategori = new ArrayList<>();
    private List<SoldoutResponse> listSoldout = new ArrayList<>();

    private View viewHome;

    public HomeFragment(){
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewHome = inflater.inflate(R.layout.fragment_home, container, false);
        mApiService = (NetworkService) RestService.getApiService();
        initView();
        setupRvKategori();
        setupRvSoldout();
        return viewHome;
    }

    private void initView() {
        rvKategori = viewHome.findViewById(R.id.rv_kategori);
        rvSoldout = viewHome.findViewById(R.id.rv_online_shop);
    }

    private void setupRvKategori() {
        rvKategori.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 4);
        rvKategori.setLayoutManager(linearLayoutManager);
    }

    private void setupRvSoldout() {
        rvSoldout.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvSoldout.setLayoutManager(linearLayoutManager);
    }

    private void loadData() {
        // Load Kategori
        rvKategori.setVisibility(View.GONE);
        listKategori.clear();
        mApiService.getKategori().enqueue(new Callback<List<KategoriResponse>>() {
            @Override
            public void onResponse(Call<List<KategoriResponse>> call, Response<List<KategoriResponse>> response) {
                if (response.isSuccessful()){
                    try {
                        int total = response.body().size();

                        for (int i = 0; i < total; i++){
                            KategoriResponse kategoriResponse = new KategoriResponse(
                                    response.body().get(i).getListOfSubKategori(),
                                    response.body().get(i).getKategoriId(),
                                    response.body().get(i).getNamaKategori()
                            );
                            listKategori.add(kategoriResponse);
                        }
                        rvKategoriAdapterAdapter = new RvKategoriAdapter(listKategori);
                        rvKategori.setAdapter(rvKategoriAdapterAdapter);

                        if (listKategori.isEmpty()){
                            rvKategori.setVisibility(View.GONE);
                            Toast.makeText(getActivity(),"Data tidak ditemukan",Toast.LENGTH_SHORT).show();
                        } else {
                            rvKategori.setVisibility(View.VISIBLE);
                        }

                    } catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please try again, server is down", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<KategoriResponse>> call, Throwable t) {

            }
        });

        // Load Soldout
        rvSoldout.setVisibility(View.GONE);
        listSoldout.clear();
        mApiService.getSoldout().enqueue(new Callback<List<SoldoutResponse>>() {
            @Override
            public void onResponse(Call<List<SoldoutResponse>> call, Response<List<SoldoutResponse>> response) {
                if (response.isSuccessful()){
                    try {
                        int total = response.body().size();

                        for (int i = 0; i < total; i++){
                            SoldoutResponse soldoutResponse = new SoldoutResponse(
                                    response.body().get(i).getNamaProduk(),
                                    response.body().get(i).getHarga(),
                                    response.body().get(i).getBerat(),
                                    response.body().get(i).getQty(),
                                    response.body().get(i).getDeskripsi(),
                                    response.body().get(i).getProdukId(),
                                    response.body().get(i).getDimensi(),
                                    response.body().get(i).getKodeProduk()

                            );
                            listSoldout.add(soldoutResponse);
                        }
                        rvSoldoutAdapter = new RvSoldoutAdapter(listSoldout);
                        rvSoldout.setAdapter(rvSoldoutAdapter);

                        if (listSoldout.isEmpty()){
                            rvSoldout.setVisibility(View.GONE);
                            Toast.makeText(getActivity(),"Data tidak ditemukan",Toast.LENGTH_SHORT).show();
                        } else {
                            rvSoldout.setVisibility(View.VISIBLE);
                        }
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please try again, server is down", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SoldoutResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

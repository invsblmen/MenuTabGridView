package com.dany.android.myapplication.network;

import com.dany.android.myapplication.modul.KategoriResponse;
import com.dany.android.myapplication.modul.SoldoutResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("api/kategori/get_kategori")
    Call<List<KategoriResponse>> getKategori();

    @GET("api/product/get_produk_sold_out")
    Call<List<SoldoutResponse>> getSoldout();
}

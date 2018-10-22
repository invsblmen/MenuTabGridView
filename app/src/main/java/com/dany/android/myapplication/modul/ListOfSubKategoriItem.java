package com.dany.android.myapplication.modul;

import com.google.gson.annotations.SerializedName;

public class ListOfSubKategoriItem{

	@SerializedName("kategori_id")
	private int kategoriId;

	@SerializedName("nama_kategori")
	private String namaKategori;

	public void setKategoriId(int kategoriId){
		this.kategoriId = kategoriId;
	}

	public int getKategoriId(){
		return kategoriId;
	}

	public void setNamaKategori(String namaKategori){
		this.namaKategori = namaKategori;
	}

	public String getNamaKategori(){
		return namaKategori;
	}

	@Override
 	public String toString(){
		return 
			"ListOfSubKategoriItem{" + 
			"kategori_id = '" + kategoriId + '\'' + 
			",nama_kategori = '" + namaKategori + '\'' + 
			"}";
		}
}
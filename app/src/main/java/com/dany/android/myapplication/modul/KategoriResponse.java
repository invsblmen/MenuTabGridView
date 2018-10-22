package com.dany.android.myapplication.modul;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KategoriResponse {

	@SerializedName("list_of_sub_kategori")
	private List<ListOfSubKategoriItem> listOfSubKategori;

	@SerializedName("kategori_id")
	private int kategoriId;

	@SerializedName("nama_kategori")
	private String namaKategori;

	public KategoriResponse(List<ListOfSubKategoriItem> listOfSubKategori, int kategoriId, String namaKategori) {
		this.listOfSubKategori = listOfSubKategori;
		this.kategoriId = kategoriId;
		this.namaKategori = namaKategori;
	}

	public void setListOfSubKategori(List<ListOfSubKategoriItem> listOfSubKategori){
		this.listOfSubKategori = listOfSubKategori;
	}

	public List<ListOfSubKategoriItem> getListOfSubKategori(){
		return listOfSubKategori;
	}

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
			"KategoriResponse{" +
			"list_of_sub_kategori = '" + listOfSubKategori + '\'' + 
			",kategori_id = '" + kategoriId + '\'' + 
			",nama_kategori = '" + namaKategori + '\'' + 
			"}";
		}
}
package com.dany.android.myapplication.modul;

import com.google.gson.annotations.SerializedName;

public class SoldoutResponse {

	@SerializedName("nama_produk")
	private String namaProduk;

	@SerializedName("harga")
	private int harga;

	@SerializedName("berat")
	private int berat;

	@SerializedName("qty")
	private int qty;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("produk_id")
	private int produkId;

	@SerializedName("dimensi")
	private int dimensi;

	@SerializedName("kode_produk")
	private String kodeProduk;

	public SoldoutResponse(String namaProduk, int harga, int berat, int qty, String deskripsi, int produkId, int dimensi, String kodeProduk) {
		this.namaProduk = namaProduk;
		this.harga = harga;
		this.berat = berat;
		this.qty = qty;
		this.deskripsi = deskripsi;
		this.produkId = produkId;
		this.dimensi = dimensi;
		this.kodeProduk = kodeProduk;
	}

	public void setNamaProduk(String namaProduk){
		this.namaProduk = namaProduk;
	}

	public String getNamaProduk(){
		return namaProduk;
	}

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setBerat(int berat){
		this.berat = berat;
	}

	public int getBerat(){
		return berat;
	}

	public void setQty(int qty){
		this.qty = qty;
	}

	public int getQty(){
		return qty;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setProdukId(int produkId){
		this.produkId = produkId;
	}

	public int getProdukId(){
		return produkId;
	}

	public void setDimensi(int dimensi){
		this.dimensi = dimensi;
	}

	public int getDimensi(){
		return dimensi;
	}

	public void setKodeProduk(String kodeProduk){
		this.kodeProduk = kodeProduk;
	}

	public String getKodeProduk(){
		return kodeProduk;
	}

	@Override
 	public String toString(){
		return 
			"SoldoutResponse{" +
			"nama_produk = '" + namaProduk + '\'' + 
			",harga = '" + harga + '\'' + 
			",berat = '" + berat + '\'' + 
			",qty = '" + qty + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",produk_id = '" + produkId + '\'' + 
			",dimensi = '" + dimensi + '\'' + 
			",kode_produk = '" + kodeProduk + '\'' + 
			"}";
		}
}
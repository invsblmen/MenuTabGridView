package com.dany.android.myapplication.network;

public class RestService {
    public static final String BASE_URL = "http://buatdevelop.com/catalog_produk/";

    public static NetworkService getApiService(){
        return RestClient.getClient(BASE_URL).create(NetworkService.class);
    }
}

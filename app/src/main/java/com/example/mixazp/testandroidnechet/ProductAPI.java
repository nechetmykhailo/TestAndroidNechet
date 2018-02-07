package com.example.mixazp.testandroidnechet;


import com.example.mixazp.testandroidnechet.model.XML;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {

    @GET("/test/test.xml")
    Call<XML> getProducts();
}

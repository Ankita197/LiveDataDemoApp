package com.ankita.livedatademo.apiclasse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("/api/v1/create")
    Call<CreateResponse> CreateEmployee(@Body User user);

}

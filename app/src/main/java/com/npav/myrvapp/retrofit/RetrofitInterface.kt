package com.npav.myrvapp.retrofit

import com.npav.myrvapp.adapter.EmpListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitInterface {

    @GET("/api/v1/GetTeamList")
    suspend fun getTeamList(
        @Header("Authorization") token: String
    ): Response<EmpListResponse>

}
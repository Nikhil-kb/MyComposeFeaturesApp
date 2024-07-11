package com.npav.myrvapp.retrofit

import com.npav.myrvapp.util.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofitInstance by lazy {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        Retrofit.Builder().baseUrl(AppConstants.BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiIntance by lazy {
        retrofitInstance.create(RetrofitInterface::class.java)
    }

    fun getInstance(): Retrofit {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        val retrofit = Retrofit.Builder().baseUrl("http://reminder1.npav.net")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()

        return retrofit

    }

}
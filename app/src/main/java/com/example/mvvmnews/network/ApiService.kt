package com.example.mvvmnews.network

import com.example.mvvmnews.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    fun getAllDataNews() : Call<List<GetAllNewsResponseItem>>

}
package com.example.continua3

import com.example.continua3.model.ListModel
import com.example.continua3.model.MessageModel
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {

    @GET("/api/v1/API")
    fun getProducts(): Call<List<ListModel>>

    @GET("/api/v1/API")
    fun getMessages(): Call<List<MessageModel>>

}
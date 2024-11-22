package com.example.dailynews.api


import com.example.dailynews.model.PhotoResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    fun getPhotos(): Call<List<PhotoResponseItem>>
}

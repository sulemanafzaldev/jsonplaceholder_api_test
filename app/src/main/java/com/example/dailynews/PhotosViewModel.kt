package com.example.dailynews

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dailynews.model.PhotoResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosViewModel : ViewModel() {

    private val _photo = MutableLiveData<List<PhotoResponseItem>>()
    val photo: LiveData<List<PhotoResponseItem>>
        get() = _photo


    fun fetchPhoto(){
        RetrofitInstance.api.getPhotos().enqueue(object :Callback<List<PhotoResponseItem>>{
            override fun onResponse(
                call: Call<List<PhotoResponseItem>>,
                response: Response<List<PhotoResponseItem>>
            ) {
                if (response.isSuccessful){
                    _photo.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<PhotoResponseItem>>, t: Throwable) {
               // Toast.makeText(, "Error", Toast.LENGTH_LONG).show()
            }

        })
    }


}
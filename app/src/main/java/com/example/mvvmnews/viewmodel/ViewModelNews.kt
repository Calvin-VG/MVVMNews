package com.example.mvvmnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmnews.model.GetAllNewsResponseItem
import com.example.mvvmnews.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel() {

    var liveDataNews : MutableLiveData<List<GetAllNewsResponseItem>> = MutableLiveData()

    @JvmName("getLiveDataNews1")
    fun getLiveDataNews(): MutableLiveData<List<GetAllNewsResponseItem>>{
        return liveDataNews
    }

    fun getDataNews(){
        ApiClient.instance.getAllDataNews()
            .enqueue(object : Callback<List<GetAllNewsResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsResponseItem>>,
                    response: Response<List<GetAllNewsResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }

}
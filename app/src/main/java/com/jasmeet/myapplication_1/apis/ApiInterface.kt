package com.jasmeet.myapplication_1.apis

import com.jasmeet.myapplication_1.model.Grocery
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/resource/9ef84268-d588-465a-a308-a864a43d0070?api-key=579b464db66ec23bdd000001769d38c5eb5e4a236ba10d186a16d490%20&format=json&offset=0&limit=32")
    suspend fun getGroceryData():Response<Grocery>
}


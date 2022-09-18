package com.jasmeet.myapplication_1.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {

    fun getInstance():Retrofit{
        return  Retrofit.Builder()
            .baseUrl("https://api.data.gov.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
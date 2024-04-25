package com.example.playground.data.api

object ApiServices {
    val countryApiService: CountryApiService by lazy {
        RetrofitService.retrofitService.create(CountryApiService::class.java)
    }
}
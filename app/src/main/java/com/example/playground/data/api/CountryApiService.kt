package com.example.playground.data.api

import com.example.playground.data.model.Country
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApiService {
    @GET("subregion/{regionName}")
    suspend fun getCountriesFromSubRegion(@Path(value = "regionName") regionName: String): List<Country>
}
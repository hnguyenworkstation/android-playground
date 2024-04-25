package com.example.playground.data.repository

import com.example.playground.data.api.CountryApiService
import com.example.playground.data.model.Country

interface CountryRepository {
    suspend fun fetchCountries(regionName: String): List<Country>
}

class CountryRepositoryImpl(
    private val countryApiService: CountryApiService
) : CountryRepository {
    override suspend fun fetchCountries(regionName: String): List<Country> {
        return countryApiService.getCountriesFromSubRegion(regionName)
    }
}
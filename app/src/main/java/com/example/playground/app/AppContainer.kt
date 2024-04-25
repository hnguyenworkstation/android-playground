package com.example.playground.app

import com.example.playground.data.api.ApiServices
import com.example.playground.data.repository.CountryRepository
import com.example.playground.data.repository.CountryRepositoryImpl

interface AppContainer {
    val countryRepository: CountryRepository
}

class AppContainerImpl: AppContainer {
    override val countryRepository: CountryRepository by lazy {
        CountryRepositoryImpl(ApiServices.countryApiService)
    }
}
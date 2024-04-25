package com.example.playground.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.playground.data.api.ApiServices
import com.example.playground.data.model.Country
import com.example.playground.data.repository.CountryRepository
import com.example.playground.data.repository.CountryRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class CountryListViewState {
    data object Loading: CountryListViewState()
    data object Error: CountryListViewState()
    data class Ready(val countries: List<Country>): CountryListViewState()
}

class CountryListViewModel(
    private val countryRepository: CountryRepository
) : ViewModel() {
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val countryRepository: CountryRepository = CountryRepositoryImpl(ApiServices.countryApiService)
                CountryListViewModel(countryRepository)
            }
        }
    }

    var uiState: CountryListViewState by mutableStateOf(CountryListViewState.Loading)
        private set

    fun load() {
        viewModelScope.launch {
            uiState = CountryListViewState.Loading
            withContext(Dispatchers.Default) {
                uiState = try {
                    val countries = countryRepository.fetchCountries("australia")
                    CountryListViewState.Ready(countries)
                } catch (e: Exception) {
                    CountryListViewState.Error
                }
            }
        }
    }
}
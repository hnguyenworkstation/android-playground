package com.example.playground.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.playground.data.model.Country

@Composable
fun CountryListRoute(uiState: CountryListViewState) {
    when(uiState) {
        is CountryListViewState.Error -> {
            //
        }
        is CountryListViewState.Loading -> {
            //
        }
        is CountryListViewState.Ready -> {
            CountryListScreen(uiState.countries, Modifier.fillMaxSize())
        }
    }
}

@Composable
fun CountryListScreen(
    countries: List<Country>,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(count = countries.size, key = {countries[it].name} ) {
            CountryCardItem(countries[it],
                Modifier
                    .fillMaxWidth()
                    .height(56.dp))
        }
    }
}

@Composable
fun CountryCardItem(
    country: Country,
    modifier: Modifier
) {
    Text(text = country.name.common, modifier = modifier)
}
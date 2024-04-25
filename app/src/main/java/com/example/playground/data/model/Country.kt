package com.example.playground.data.model

import kotlinx.serialization.Serializable

@Serializable
class Country (
    val name: Name,
    val capital: List<String>,
    val languages: HashMap<String, String>
)

@Serializable
data class Name (
    val common: String
)

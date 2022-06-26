package com.example.ps_eis

import kotlinx.serialization.Serializable

@Serializable
data class DataClass(
    val userId: String,
    val id: String,
    val title: String,
    val body: String
)
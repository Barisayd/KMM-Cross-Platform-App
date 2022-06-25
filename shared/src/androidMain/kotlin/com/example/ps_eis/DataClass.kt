package com.example.ps_eis

import kotlinx.serialization.Serializable

@Serializable
data class DataClass(
    val format_view: String,
    val lang_view: String,
)
package com.example.databencana.data

data class SupportedArea(
    val id: String,
    val city: String,
)

val listArea = listOf<SupportedArea>(
    SupportedArea("ID-AC", "Aceh"),
    SupportedArea("ID-BA", "Bali"),
    SupportedArea("ID-BB", "Kep Bangka Belitung"),
    SupportedArea("ID-BT", "Banten"),
    SupportedArea("ID-BE", "Bengkulu"),
)
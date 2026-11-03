package com.example.myapp

import java.io.Serializable

data class ItemModel(
    val title: String,
    val description: String
) : Serializable
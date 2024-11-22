package com.example.dailynews.model

data class PhotoResponseItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)
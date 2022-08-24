package dev.vaibhav.musicx.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "category")
    val category: String,
    @Json(name = "desc")
    val desc: String,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "name")
    val name: String
)
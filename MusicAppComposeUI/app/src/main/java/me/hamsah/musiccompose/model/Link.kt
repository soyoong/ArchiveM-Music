package me.hamsah.musiccompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Link(
    @Json(name = "active")
    val active: Boolean,
    @Json(name = "label")
    val label: String,
    @Json(name = "url")
    val url: String
)
package me.hamsah.musiccompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Recommendation(
    @Json(name = "data")
    val `data`: List<Banner>,
    @Json(name = "links")
    val links: Links,
    @Json(name = "meta")
    val meta: Meta,
    @Json(name = "status")
    val status: Int,
    @Json(name = "success")
    val success: Boolean
)
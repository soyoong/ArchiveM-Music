package me.hamsah.musiccompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Music(
    @Json(name = "artist")
    val artist: String,
    @Json(name = "artist_id")
    val artistId: Int,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "deleted_at")
    val deletedAt: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "total_songs")
    val totalSongs: String,
    @Json(name = "total_views")
    val totalViews: String,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "image_url")
    val image_url: InfoImage,
    @Json(name = "user")
    val user: User
)
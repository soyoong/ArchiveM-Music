package me.hamsah.musiccompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoImage(
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "deleted_at")
    val deletedAt: Any,
    @Json(name = "extension")
    val extension: String,
    @Json(name = "file_name")
    val fileName: String,
    @Json(name = "file_original_name")
    val fileOriginalName: String,
    @Json(name = "file_size")
    val fileSize: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "type")
    val type: String,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "user_id")
    val userId: Int
)
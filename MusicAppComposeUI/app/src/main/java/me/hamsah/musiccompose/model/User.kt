package me.hamsah.musiccompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "address")
    val address: Any,
    @Json(name = "artist")
    val artist: Any,
    @Json(name = "avatar")
    val avatar: Any,
    @Json(name = "avatar_original")
    val avatarOriginal: String,
    @Json(name = "balance")
    val balance: Int,
    @Json(name = "banned")
    val banned: Int,
    @Json(name = "business_license")
    val businessLicense: Any,
    @Json(name = "city")
    val city: Any,
    @Json(name = "country")
    val country: Any,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "customer_package_id")
    val customerPackageId: Any,
    @Json(name = "device_token")
    val deviceToken: Any,
    @Json(name = "email")
    val email: String,
    @Json(name = "email_verified_at")
    val emailVerifiedAt: String,
    @Json(name = "finished_at")
    val finishedAt: Any,
    @Json(name = "id")
    val id: Int,
    @Json(name = "identity_card")
    val identityCard: Any,
    @Json(name = "name")
    val name: String,
    @Json(name = "new_email_verificiation_code")
    val newEmailVerificiationCode: Any,
    @Json(name = "phone")
    val phone: Any,
    @Json(name = "postal_code")
    val postalCode: Any,
    @Json(name = "provider_id")
    val providerId: Any,
    @Json(name = "referral_code")
    val referralCode: Any,
    @Json(name = "referred_by")
    val referredBy: Any,
    @Json(name = "remaining_uploads")
    val remainingUploads: Int,
    @Json(name = "role")
    val role: Any,
    @Json(name = "started_at")
    val startedAt: Any,
    @Json(name = "state")
    val state: Any,
    @Json(name = "status")
    val status: Any,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "user_type")
    val userType: String,
    @Json(name = "verification_code")
    val verificationCode: Any
)
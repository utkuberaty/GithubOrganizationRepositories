package com.utku.organizationgithubrepositories.data.entities

import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Permissions(
    val admin: Boolean = false,
    val maintain: Boolean = false,
    val push: Boolean = false,
    val triage: Boolean = false,
    val pull: Boolean = false
)

class PermissionsTypeConverter {
    @TypeConverter
    fun fromPermissions(permissions: Permissions): String = Json.encodeToString(permissions)

    @TypeConverter
    fun toPermissions(permissions: String): Permissions = Json.decodeFromString(permissions)
}
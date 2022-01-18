package com.utku.organizationgithubrepositories.data.type_converter

import androidx.room.TypeConverter
import com.utku.organizationgithubrepositories.data.entities.Permissions
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PermissionsTypeConverter {
    @TypeConverter
    fun fromPermissions(permissions: Permissions): String = Json.encodeToString(permissions)

    @TypeConverter
    fun toPermissions(permissions: String): Permissions = Json.decodeFromString(permissions)
}
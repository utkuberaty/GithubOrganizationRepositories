package com.utku.organizationgithubrepositories.data.type_converter

import androidx.room.TypeConverter
import com.utku.organizationgithubrepositories.data.entities.Owner
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class OwnerTypeConverter {
    @TypeConverter
    fun fromOwner(owner: Owner): String = Json.encodeToString(owner)

    @TypeConverter
    fun toOwner(owner: String): Owner = Json.decodeFromString(owner)
}
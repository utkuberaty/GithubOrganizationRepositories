package com.utku.organizationgithubrepositories.data.entities

import androidx.room.ColumnInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(
    val login: String = "",
    val id: Int = 0,
    @ColumnInfo(name = "avatar_url")
    @SerialName("avatar_url")
    val avatarUrl: String = "",
    val url: String = "",
    val type: String = ""
)


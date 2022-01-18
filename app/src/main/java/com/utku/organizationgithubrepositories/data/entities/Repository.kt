package com.utku.organizationgithubrepositories.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.utku.organizationgithubrepositories.R
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "repository")
data class Repository(
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    @ColumnInfo(name = "full_name")
    @SerialName("full_name")
    val fullName: String = "",
    @ColumnInfo(name = "private")
    @SerialName("private")
    val isPrivate: Boolean = false,
    val owner: Owner = Owner(),
    @ColumnInfo(name = "html_url")
    @SerialName("html_url")
    val htmlUrl: String = "",
    val description: String = "",
    val fork: Boolean = false,
    val url: String = "",
    @ColumnInfo(name = "created_at")
    @SerialName("created_at")
    val createdAt: String = "",
    @ColumnInfo(name = "updated_at")
    @SerialName("updated_at")
    val updatedAt: String = "",
    @ColumnInfo(name = "pushed_at")
    @SerialName("pushed_at")
    val pushedAt: String = "",
    @ColumnInfo(name = "git_url")
    @SerialName("git_url")
    val gitUrl: String = "",
    val homepage: String = "",
    val size: Int = 0,
    @ColumnInfo(name = "stargazers_count")
    @SerialName("stargazers_count")
    val stargazersCount: Int = 0,
    @ColumnInfo(name = "watchers_count")
    @SerialName("watchers_count")
    val watchersCount: Int = 0,
    val language: String = "",
    @ColumnInfo(name = "has_issues")
    @SerialName("has_issues")
    val hasIssues: Boolean = false,
    @ColumnInfo(name = "forks_count")
    @SerialName("forks_count")
    val forksCount: Int = 0,
    val archived: Boolean = false,
    @ColumnInfo(name = "open_issues_count")
    @SerialName("open_issues_count")
    val openIssues_count: Int = 0,
    @ColumnInfo(name = "allow_forking")
    @SerialName("allow_forking")
    val allowForking: Boolean = false,
    val visibility: String = "",
    val forks: Int = 0,
    @ColumnInfo(name = "open_issues")
    @SerialName("open_issues")
    val openIssues: Int = 0,
    val watchers: Int = 0,
    val permissions: Permissions = Permissions()
) {

    val languageColor: LanguageColor
        get() {
            return if (LanguageColor.values().any { it.name == language.uppercase() }) {
                LanguageColor.valueOf(language.uppercase())
            } else LanguageColor.DEFAULT
        }
}

enum class LanguageColor(val resId: Int) {
    KOTLIN(R.color.kotlin), JAVA(R.color.java),
    RUBY(R.color.ruby), OBJECTIVE_C(R.color.objective_C),
    JAVA_SCRIPT(R.color.javaScript), CSS(R.color.css),
    SHELL(R.color.shell), SWIFT(R.color.swift), DEFAULT(R.color.default_language)
}

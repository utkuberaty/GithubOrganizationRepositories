package com.utku.organizationgithubrepositories.util

import com.utku.organizationgithubrepositories.data.entities.Repository

fun createTestRepositoryList(count: Int): List<Repository> = List(count) {
    Repository(
        it,
        getTestRandomString(5),
        getTestRandomString(10),
    )
}

fun getTestRandomString(length: Int) : String {
    val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}
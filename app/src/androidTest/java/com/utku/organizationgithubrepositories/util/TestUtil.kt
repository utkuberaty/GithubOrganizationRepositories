package com.utku.organizationgithubrepositories.util

import com.utku.organizationgithubrepositories.data.entities.Repository


fun createRepositoryList(count: Int): List<Repository> = List(count) {
    Repository(
        it,
        getRandomString(5),
        getRandomString(10),
    )
}

fun getRandomString(length: Int) : String {
    val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}
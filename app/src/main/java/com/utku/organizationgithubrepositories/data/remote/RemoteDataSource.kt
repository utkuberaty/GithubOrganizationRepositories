package com.utku.organizationgithubrepositories.data.remote

import com.utku.organizationgithubrepositories.data.entities.Repository

/**
 * Remote data source to call github api service for [Repository] list.
 * */

class RemoteDataSource(private val githubApiService: GithubApiService) : Call() {
    suspend fun getRepositoryList(organization: String) = call {
        githubApiService.getRepositories(organization)
    }
}
package com.utku.organizationgithubrepositories.data.repository

import com.utku.organizationgithubrepositories.data.entities.Repository
import com.utku.organizationgithubrepositories.data.remote.Result
import kotlinx.coroutines.flow.Flow

interface GithubHubApiRepository {
    fun getRepositoryList(
        organization: String,
        userLocalData: Boolean
    ): Flow<Result<List<Repository>>>
}
package com.utku.organizationgithubrepositories.repository

import com.utku.organizationgithubrepositories.data.entities.Repository
import com.utku.organizationgithubrepositories.data.remote.Result
import com.utku.organizationgithubrepositories.data.repository.GithubHubApiRepository
import com.utku.organizationgithubrepositories.util.createTestRepositoryList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GithubHubApiRepositoryTest : GithubHubApiRepository {

    private var repositoryList = createTestRepositoryList(10)

    override fun getRepositoryList(
        organization: String,
        userLocalData: Boolean
    ): Flow<Result<List<Repository>>> {
        return flow { emit(Result.Success(repositoryList)) }
    }
}
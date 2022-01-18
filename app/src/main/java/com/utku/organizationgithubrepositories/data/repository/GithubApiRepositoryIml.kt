package com.utku.organizationgithubrepositories.data.repository

import com.utku.organizationgithubrepositories.data.entities.Repository
import com.utku.organizationgithubrepositories.data.local.LocalDataSource
import com.utku.organizationgithubrepositories.data.remote.RemoteDataSource
import com.utku.organizationgithubrepositories.data.remote.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * [GithubApiRepositoryIml] injects via hilt
 * Uses remote and local data sources
 * */

class GithubApiRepositoryIml @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : BaseRepository(), GithubHubApiRepository {

    /**
     * Gets given area [Repository] list from local or remote datasource and returns [Result]
     * If userLocalData false, It's always use new data from remote
     * */

    override fun getRepositoryList(
        organization: String,
        userLocalData: Boolean
    ): Flow<Result<List<Repository>>> =
        performGetOperation(
            { localDataSource.getAllRepositories() },
            { remoteDataSource.getRepositoryList(organization) },
            { localDataSource.insertAllRepositories(it) },
            userLocalData
        )
}
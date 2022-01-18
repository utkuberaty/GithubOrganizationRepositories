package com.utku.organizationgithubrepositories.data.local

import com.utku.organizationgithubrepositories.data.entities.Repository

/**
 * Local data source for [Repository] list
 * Inserts and Gets [Repository] list
 * */

class LocalDataSource(private val gitHubApiDao: GitHubApiDao) {

    suspend fun getAllRepositories(): List<Repository> = gitHubApiDao.getAllRepositories()

    suspend fun insertAllRepositories(repositoryList: List<Repository>) =
        gitHubApiDao.insertAllRepositories(repositoryList)

}
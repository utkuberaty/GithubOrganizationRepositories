package com.utku.organizationgithubrepositories.di

import com.utku.organizationgithubrepositories.data.local.GitHubApiDao
import com.utku.organizationgithubrepositories.data.local.LocalDataSource
import com.utku.organizationgithubrepositories.data.remote.GithubApiService
import com.utku.organizationgithubrepositories.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt singleton Component module for data sources
 * */

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun remoteDataSource(githubApiService: GithubApiService) = RemoteDataSource(githubApiService)

    @Provides
    @Singleton
    fun localDataSource(gitHubApiDao: GitHubApiDao) = LocalDataSource(gitHubApiDao)
}
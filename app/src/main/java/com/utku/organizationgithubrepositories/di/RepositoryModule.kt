package com.utku.organizationgithubrepositories.di

import com.utku.organizationgithubrepositories.data.local.LocalDataSource
import com.utku.organizationgithubrepositories.data.remote.RemoteDataSource
import com.utku.organizationgithubrepositories.data.repository.GithubApiRepositoryIml
import com.utku.organizationgithubrepositories.data.repository.GithubHubApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Hilt singleton Component module for repositories
 * */

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun getGithubHubApiRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): GithubHubApiRepository = GithubApiRepositoryIml(remoteDataSource, localDataSource)
}
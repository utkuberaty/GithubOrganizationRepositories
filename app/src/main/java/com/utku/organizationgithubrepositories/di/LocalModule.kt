package com.utku.organizationgithubrepositories.di

import android.content.Context
import androidx.room.Room
import com.utku.organizationgithubrepositories.data.local.AppDatabase
import com.utku.organizationgithubrepositories.data.local.GitHubApiDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt singleton Component module for local DB
 * */

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun appDataBase(@ApplicationContext context: Context): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "GithubApiService.db")
        .fallbackToDestructiveMigration()
        .build()


    @Provides
    @Singleton
    fun myTaxiDao(appDatabase: AppDatabase): GitHubApiDao = appDatabase.githubApiDao()
}
package com.utku.organizationgithubrepositories.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.utku.organizationgithubrepositories.data.entities.Repository

/**
 * Dao interface for [Repository]
 * Includes CRUD operations to insert or read [Repository]
 * */

@Dao
interface GitHubApiDao {

    @Query("SELECT * From repository")
    suspend fun getAllRepositories(): List<Repository>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRepositories(repositoryList: List<Repository>)
}
package com.utku.organizationgithubrepositories.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.utku.organizationgithubrepositories.data.entities.PermissionsTypeConverter
import com.utku.organizationgithubrepositories.data.entities.Repository
import com.utku.organizationgithubrepositories.data.entities.Owner
import com.utku.organizationgithubrepositories.data.entities.Permissions
import com.utku.organizationgithubrepositories.data.type_converter.OwnerTypeConverter

/**
 * Initialize RoomDatabase [GitHubApiDao] and It's entities [Repository]
 * Uses TypeConverter [OwnerTypeConverter] and [PermissionsTypeConverter] to convert [Owner] and [Permissions]
 * */

@Database(entities = [Repository::class], version = 1, exportSchema = true)
@TypeConverters(PermissionsTypeConverter::class, OwnerTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun githubApiDao(): GitHubApiDao
}
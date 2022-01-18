package com.utku.organizationgithubrepositories.local

import androidx.test.filters.SmallTest
import com.utku.organizationgithubrepositories.data.entities.Repository
import com.utku.organizationgithubrepositories.data.local.AppDatabase
import com.utku.organizationgithubrepositories.data.local.GitHubApiDao
import com.utku.organizationgithubrepositories.util.createRepositoryList
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class GitHubApiDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test_db")
    lateinit var db: AppDatabase

    private lateinit var gitHubApiDao: GitHubApiDao

    @Before
    fun createDb() {
        hiltRule.inject()
        gitHubApiDao = db.githubApiDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() = runBlocking {
        val count = 3
        val repositoryList: List<Repository> = createRepositoryList(count)
        gitHubApiDao.insertAllRepositories(repositoryList)
        val testPoiList: List<Repository> = gitHubApiDao.getAllRepositories()
        assertEquals(repositoryList, testPoiList)
    }


}
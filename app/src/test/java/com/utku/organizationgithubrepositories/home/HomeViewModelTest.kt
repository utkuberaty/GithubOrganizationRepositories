package com.utku.organizationgithubrepositories.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.utku.organizationgithubrepositories.MainCoroutineRule
import com.utku.organizationgithubrepositories.data.remote.Result
import com.utku.organizationgithubrepositories.repository.GithubHubApiRepositoryTest
import com.utku.organizationgithubrepositories.ui.home.HomeViewModel
import com.utku.organizationgithubrepositories.util.DEFAULT_ORGANIZATION
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(GithubHubApiRepositoryTest())
    }


    @Test
    fun `get repository list data`() {
        runBlockingTest {
            viewModel.fetchRepository(DEFAULT_ORGANIZATION, true).collect { result ->
                if (result is Result.Success) {
                    println("result is => $result")
                    assert(!result.data.isNullOrEmpty())
                } else {
                    println(result)
                    assert(false)
                }
            }
        }
    }

}
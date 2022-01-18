package com.utku.organizationgithubrepositories.ui.home

import com.utku.organizationgithubrepositories.data.repository.GithubHubApiRepository
import com.utku.organizationgithubrepositories.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
* HomeViewModel, injects [GithubHubApiRepository] from Hilt
* */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val githubHubApiRepository: GithubHubApiRepository
) : BaseViewModel() {

    fun fetchRepository(organization: String, useLocal: Boolean = true) =
        githubHubApiRepository.getRepositoryList(organization, useLocal)

}
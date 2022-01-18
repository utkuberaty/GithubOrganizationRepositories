package com.utku.organizationgithubrepositories.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.utku.organizationgithubrepositories.data.entities.Repository
import com.utku.organizationgithubrepositories.data.remote.Result
import com.utku.organizationgithubrepositories.databinding.ActivityHomeBinding
import com.utku.organizationgithubrepositories.ui.base.BaseActivity
import com.utku.organizationgithubrepositories.util.DEFAULT_ORGANIZATION
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Launcher activity, extends [BaseActivity]
 * Fetches github [Repository] list and shows with detail
 * */

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>({ ActivityHomeBinding.inflate(it) }) {

    private val repositoryList: MutableList<Repository> = mutableListOf()

    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRecyclerview()
        fetchRepositoryList()
        onSwipeRefresh()
    }

    /**
     * Setting up recyclerView
     * */
    private fun setRecyclerview() {
        viewBinding.repositoriesRecyclerView.apply {
            adapter = RepositoryListAdapter(repositoryList)
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
        }
    }

    /**
     * Refresh [repositoryList] with new data
     * */
    private fun setData(repositories: List<Repository>) {
        repositoryList.clear()
        repositoryList.addAll(repositories)
        viewBinding.repositoriesRecyclerView.adapter?.notifyDataSetChanged()
        viewBinding.repositoriesRecyclerView.visibility = View.VISIBLE
    }

    /**
     * if list empty recyclerView visibility gone
     * */
    private fun dataEmpty() {
        viewBinding.repositoriesRecyclerView.visibility = View.GONE
    }

    /**
     * Setting up Swipe refresh listener
     * */
    private fun onSwipeRefresh() {
        viewBinding.swipeContainer.setOnRefreshListener {
            fetchRepositoryList(false)
        }
    }

    /**
     * Fetch [Repository] list from dataSources via [HomeViewModel]
     * */
    private fun fetchRepositoryList(useLocal: Boolean = true) {
        lifecycleScope.launch {
            viewModel.fetchRepository(DEFAULT_ORGANIZATION, useLocal).collect {
                if (it is Result.Success) {
                    if (!it.data.isNullOrEmpty()) setData(it.data)
                    else dataEmpty()
                } else if (it is Result.Error) {
                    showErrorMessage(it.exception)
                    dataEmpty()
                }
                viewBinding.swipeContainer.isRefreshing = false
            }
        }
    }

}
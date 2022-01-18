package com.utku.organizationgithubrepositories.data.remote

import com.utku.organizationgithubrepositories.data.entities.Repository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Api service for fetch organization repositories to get [Repository] list
 * */

interface GithubApiService {

    @GET("{organization}/repos")
    suspend fun getRepositories(
        @Path("organization") organization: String
    ): Response<List<Repository>>
}
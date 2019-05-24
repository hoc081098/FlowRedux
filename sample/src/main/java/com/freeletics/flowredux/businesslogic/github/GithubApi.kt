package com.freeletics.flowredux.businesslogic.github

import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun search(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): GithubSearchResults
}

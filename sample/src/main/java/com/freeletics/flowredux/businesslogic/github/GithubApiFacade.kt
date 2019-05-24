package com.freeletics.flowredux.businesslogic.github

import javax.inject.Inject

/**
 * Simple facade that hides the internals from the outside
 */
class GithubApiFacade @Inject constructor(private val githubApi: GithubApi) {

    suspend fun loadNextPage(page: Int) = githubApi.search(
        query = "language:java",
        page = page,
        sort = "stars"
    )
}

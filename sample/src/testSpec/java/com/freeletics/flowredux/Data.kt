package com.freeletics.flowredux

import com.freeletics.flowredux.businesslogic.github.GithubRepository

val FIRST_PAGE: List<GithubRepository> by lazy {
    val r = 1..30L

    r.map { i ->
        GithubRepository(
            id = i,
            name = "Repo$i",
            stars = 100 - i
        )
    }
}

val SECOND_PAGE: List<GithubRepository> by lazy {
    val r = 31..60L

    r.map { i ->
        GithubRepository(
            id = i,
            name = "Repo$i",
            stars = 100 - i
        )
    }
}

package com.freeletics.flowredux

import com.freeletics.flowredux.businesslogic.github.GithubApi
import com.freeletics.flowredux.businesslogic.pagination.PaginationStateMachine
import com.freeletics.flowredux.di.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[ApplicationModule::class] )
interface TestComponent {

    fun paginationStateMachine(): PaginationStateMachine

    fun airplaceModeDecoratedGithubApi() : GithubApi
}

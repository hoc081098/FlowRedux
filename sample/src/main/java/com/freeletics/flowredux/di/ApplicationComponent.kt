package com.freeletics.flowredux.di

import com.freeletics.flowredux.PopularRepositoriesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[ApplicationModule::class] )
interface ApplicationComponent {

    fun inject(into: PopularRepositoriesActivity)
}

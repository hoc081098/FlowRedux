package com.freeletics.flowredux.di

import com.freeletics.flowredux.ViewBindingFactory
import com.freeletics.flowredux.ViewBindingInstantiatorMap
import com.freeletics.flowredux.businesslogic.github.GithubApi
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
open class ApplicationModule(
    private val baseUrl: String,
    private val viewBindingInstantiatorMap: ViewBindingInstantiatorMap,
    private val androidScheduler: Scheduler
) {

    @Provides
    @Singleton
    open fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    @Singleton
    open fun provideGithubApi(okHttp: OkHttpClient): GithubApi {
        val retrofit =
            Retrofit.Builder()
                .client(okHttp)
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(baseUrl)
                .build()

        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideViewBindingFactory() = ViewBindingFactory(viewBindingInstantiatorMap)

    @Provides
    @Singleton
    @AndroidScheduler
    fun androidScheduler() = androidScheduler
}

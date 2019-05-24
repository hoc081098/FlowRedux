package com.freeletics.flowredux

import android.app.Application
import android.view.ViewGroup
import com.freeletics.flowredux.di.ApplicationModule
import com.freeletics.flowredux.di.DaggerApplicationComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber

open class SampleApplication : Application() {
    init {
        Timber.plant(Timber.DebugTree())
    }

    val applicationComponent by lazy {
        DaggerApplicationComponent.builder().apply {
            componentBuilder(this)
        }.build()
    }

    protected open fun componentBuilder(builder: DaggerApplicationComponent.Builder): DaggerApplicationComponent.Builder =
        builder.applicationModule(
            ApplicationModule(
                baseUrl = "https://api.github.com",
                androidScheduler = AndroidSchedulers.mainThread(),
                viewBindingInstantiatorMap = mapOf<Class<*>,
                        ViewBindingInstantiator>(
                    PopularRepositoriesActivity::class.java to { rootView: ViewGroup ->
                        PopularRepositoriesViewBinding(
                            rootView
                        )
                    }
                )
            )
        )
}

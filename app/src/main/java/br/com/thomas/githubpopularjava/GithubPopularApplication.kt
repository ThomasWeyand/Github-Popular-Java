package br.com.thomas.githubpopularjava

import android.annotation.SuppressLint
import android.app.Application
import br.com.thomas.githubpopularjava.di.networkModule
import br.com.thomas.githubpopularjava.di.repositoryModule
import br.com.thomas.githubpopularjava.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@SuppressLint("Registered")
class GithubPopularApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@GithubPopularApplication)
            modules(listOf(networkModule, repositoryModule, viewmodelModule))
        }
    }
}
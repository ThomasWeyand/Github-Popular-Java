package br.com.thomas.githubpopularjava.di

import androidx.annotation.NonNull
import br.com.thomas.githubpopularjava.BuildConfig
import br.com.thomas.githubpopularjava.network.GithubApi
import br.com.thomas.githubpopularjava.network.service.IRepositoryService
import br.com.thomas.githubpopularjava.network.service.RepositoryService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { repositoryService(get()) }
    single { githubApi(get()) }
    single { provideRetrofit(get()) }
    single { provideOkhttpClient() }
}


fun repositoryService(api: GithubApi): IRepositoryService {
    return RepositoryService(api = api)
}


fun githubApi(@NonNull retrofit: Retrofit): GithubApi {
    return retrofit.create(GithubApi::class.java)
}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


fun provideOkhttpClient(
): OkHttpClient =
    OkHttpClient.Builder()
        .build()

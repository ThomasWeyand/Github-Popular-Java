package br.com.thomas.githubpopularjava.di

import br.com.thomas.githubpopularjava.network.service.IRepositoryService
import br.com.thomas.githubpopularjava.repository.GithubRepository
import br.com.thomas.githubpopularjava.repository.IGithubRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { getGithubRepository(get()) }
}

fun getGithubRepository(service: IRepositoryService) : IGithubRepository {
    return GithubRepository(service)
}
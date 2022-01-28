package br.com.thomas.githubpopularjava.repository

import br.com.thomas.githubpopularjava.model.PopularRepositories

interface IGithubRepository {

    suspend fun getPopularRepositories(page: Int) : PopularRepositories

}
package br.com.thomas.githubpopularjava.repository

import br.com.thomas.githubpopularjava.mapper.mapFromResponse
import br.com.thomas.githubpopularjava.model.PopularRepositories
import br.com.thomas.githubpopularjava.network.base.Result
import br.com.thomas.githubpopularjava.network.service.IRepositoryService

class GithubRepository(private val service: IRepositoryService) : IGithubRepository {

    override suspend fun getPopularRepositories(page: Int): PopularRepositories {
        return when(val result = service.fetchPopularJava(page = page)) {
            is Result.Success -> result.data.mapFromResponse()
            is Result.Error -> throw result.error
        }
    }
}
package br.com.thomas.githubpopularjava.network.service

import br.com.thomas.githubpopularjava.network.GithubApi
import br.com.thomas.githubpopularjava.network.base.BaseService
import br.com.thomas.githubpopularjava.network.base.Result
import br.com.thomas.githubpopularjava.network.response.RepositoryResponse

class RepositoryService(private val api: GithubApi) : BaseService(), IRepositoryService {

    override suspend fun fetchPopularJava(page: Int): Result<RepositoryResponse> {
        return createCall { api.getPopularJava(page = page) }
    }
}
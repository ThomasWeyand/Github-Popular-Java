package br.com.thomas.githubpopularjava.network.service

import br.com.thomas.githubpopularjava.network.base.Result
import br.com.thomas.githubpopularjava.network.response.RepositoryResponse

interface IRepositoryService {

    suspend fun fetchPopularJava(page: Int) : Result<RepositoryResponse>
}
package br.com.thomas.githubpopularjava.network

import br.com.thomas.githubpopularjava.network.response.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun getPopularJava(
        @Query("q") searchTopic: String = "language:Java",
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("page") page: Int
    ): Response<RepositoryResponse>

}
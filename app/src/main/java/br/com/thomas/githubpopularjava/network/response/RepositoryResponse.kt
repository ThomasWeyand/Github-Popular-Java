package br.com.thomas.githubpopularjava.network.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<Item>
)

data class Item(
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeID: String,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("fork") val fork: Boolean,
    @SerializedName("size") val size: Int,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("watchers_count") val watchersCount: Int,
    @SerializedName("language") val language: String,
    @SerializedName("forks_count") val forksCount: Int,
    @SerializedName("default_branch") val defaultBranch: String,
    @SerializedName("score") val score: Float
)

data class Owner(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeID: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("gravatar_id") val gravatarID: String,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
)
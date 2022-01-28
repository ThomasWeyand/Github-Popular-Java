package br.com.thomas.githubpopularjava.mapper

import br.com.thomas.githubpopularjava.model.PopularRepositories
import br.com.thomas.githubpopularjava.network.response.Item
import br.com.thomas.githubpopularjava.network.response.Owner
import br.com.thomas.githubpopularjava.network.response.RepositoryResponse

fun RepositoryResponse.mapFromResponse() = PopularRepositories(
    totalCount = totalCount,
    incompleteResults = incompleteResults,
    items = items.map { it.map() }
)

fun Item.map() = br.com.thomas.githubpopularjava.model.Item(
    id = id,
    defaultBranch = defaultBranch,
    description = description,
    fork = fork,
    forksCount = forksCount,
    fullName = fullName,
    htmlUrl = htmlUrl,
    language = language,
    name = name,
    nodeID = nodeID,
    owner = owner.map(),
    score = score,
    size = size,
    stargazersCount = stargazersCount,
    watchersCount = watchersCount
)

fun Owner.map() = br.com.thomas.githubpopularjava.model.Owner(
    login = login,
    nodeID = nodeID,
    id = id,
    avatarUrl = avatarUrl,
    gravatarID = gravatarID,
    type = type,
    url = url
)
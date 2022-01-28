package br.com.thomas.githubpopularjava.ui.adapter.paged

import androidx.paging.PagingSource
import br.com.thomas.githubpopularjava.model.Item
import br.com.thomas.githubpopularjava.repository.IGithubRepository
import timber.log.Timber
import java.lang.Exception

class PopulaRepositorySource(private val repository: IGithubRepository) :
    PagingSource<Int, Item>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val nextPage = params.key ?: 1

            val result = repository.getPopularRepositories(nextPage)
            Timber.i("Page number: $nextPage")
            Timber.i("Result list: ${result.items.size}")
            Timber.i("Items faltantes: ${result.totalCount}")

            LoadResult.Page(
                data = result.items,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
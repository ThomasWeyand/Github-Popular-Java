package br.com.thomas.githubpopularjava.ui.home

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.thomas.githubpopularjava.model.Item
import br.com.thomas.githubpopularjava.repository.IGithubRepository
import br.com.thomas.githubpopularjava.ui.adapter.paged.PopulaRepositorySource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class MainViewModel(private val repository: IGithubRepository) : ViewModel() {

    val repositories: Flow<PagingData<Item>> = getRepositoryPagingData()


        private fun getRepositoryPagingData() : Flow<PagingData<Item>>{
        return Pager(PagingConfig(pageSize = 50, prefetchDistance = 15)){
            PopulaRepositorySource(repository)
        }.flow

    }
}
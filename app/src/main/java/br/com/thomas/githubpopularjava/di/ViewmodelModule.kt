package br.com.thomas.githubpopularjava.di

import br.com.thomas.githubpopularjava.ui.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { MainViewModel(get()) }
}


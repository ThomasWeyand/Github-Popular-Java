package br.com.thomas.githubpopularjava.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.thomas.githubpopularjava.R
import br.com.thomas.githubpopularjava.ui.adapter.RepositoryAdapter
import br.com.thomas.githubpopularjava.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter by lazy { RepositoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        initViewModelLifeCycleData()
    }

    private fun initRecycler(){
        repositoryRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = this@MainActivity.adapter
        }
    }

    private fun initViewModelLifeCycleData(){
        lifecycleScope.launch {
            viewModel.repositories.collect {
                Timber.i("Submit items: $it")
                Timber.i("List size: ${adapter.itemCount}")
                adapter.submitData(it)
            }
        }
    }

}

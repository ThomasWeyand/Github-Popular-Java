package br.com.thomas.githubpopularjava.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import br.com.thomas.githubpopularjava.R
import br.com.thomas.githubpopularjava.model.Item

class RepositoryAdapter : PagingDataAdapter<Item, RepositoryViewHolder>(repositoryComparator) {


    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        )
    }

    companion object{
        private val repositoryComparator = object : DiffUtil.ItemCallback<Item>(){
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
               return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

        }
    }


}
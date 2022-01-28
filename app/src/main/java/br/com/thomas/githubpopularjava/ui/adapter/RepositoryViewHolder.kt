package br.com.thomas.githubpopularjava.ui.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.thomas.githubpopularjava.model.Item
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Item) {
        itemView.apply {
            setProfilePic(item.owner.avatarUrl, profilePic)

            title?.text = item.name
            description?.text = item.description
            forkCount?.text = item.forksCount.toString()
            starsCount?.text = item.stargazersCount.toString()

            username?.text = item.owner.login
        }
    }

    private fun setProfilePic(url: String, target: AppCompatImageView?) {
        target?.apply {
            context?.let { safeContext ->
                Glide.with(safeContext)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(this)
            }
        }
    }

}
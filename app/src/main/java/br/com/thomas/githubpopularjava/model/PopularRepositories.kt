package br.com.thomas.githubpopularjava.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PopularRepositories(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val items: List<Item>
) : Parcelable

@Parcelize
data class Item(
   val id: Int,
   val nodeID: String,
   val name: String,
   val fullName: String,
   val owner: Owner,
   val htmlUrl: String,
   val description: String,
   val fork: Boolean,
   val size: Int,
   val stargazersCount: Int,
   val watchersCount: Int,
   val language: String,
   val forksCount: Int,
   val defaultBranch: String,
   val score: Float
) : Parcelable

@Parcelize
data class Owner(
    val login: String,
    val id: Int,
    val nodeID: String,
    val avatarUrl: String,
    val gravatarID: String,
    val url: String,
    val type: String
) : Parcelable
package com.utku.organizationgithubrepositories.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.utku.organizationgithubrepositories.data.entities.Repository
import com.utku.organizationgithubrepositories.databinding.ItemRepositoryBinding

/**
 *Adapter for [ItemRepositoryBinding] to list [Repository] list to [HomeActivity]
 * */

internal class RepositoryListAdapter(private val repositoryList: List<Repository>) :
    RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repositoryList[position])
    }

    override fun getItemCount(): Int = repositoryList.size


    class ViewHolder(private val viewBinding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        /**
         * public function to bind views
         * */

        fun bind(repository: Repository) {
            viewBinding.apply {
                with(repository) {
                    setLanguageColor(this@apply, this)
                    setTexts(this@apply, this)
                    logoImageView.load(owner.avatarUrl) {
                        transformations(CircleCropTransformation())
                    }
                }
            }
        }

        private fun setTexts(viewBinding: ItemRepositoryBinding, repository: Repository) {
            viewBinding.apply {
                with(repository) {
                    repositoryNameTextView.text = name
                    repositoryDescriptionTextView.text = getDescription(this)
                    forkCountTextView.text = forksCount.toString()
                    starCountTextView.text = stargazersCount.toString()
                }
            }
        }

        /**
         * Returns description if description is empty returns fullName
         * */
        private fun getDescription(repository: Repository) =
            if (repository.description.isEmpty()) repository.fullName
            else repository.description


        /**
         * Sets repository's language color and name
         * */
        private fun setLanguageColor(viewBinding: ItemRepositoryBinding, repository: Repository) {
            viewBinding.apply {
                with(repository) {
                    if (language.isNotEmpty() && language.uppercase() != "NULL") {
                        languageColorLinearLayout.visibility = View.VISIBLE
                        languageColorView.backgroundTintList = AppCompatResources.getColorStateList(
                            viewBinding.root.context,
                            languageColor.resId
                        )
                        languageTextView.text = language
                    } else languageColorLinearLayout.visibility = View.GONE
                }
            }
        }

    }

}
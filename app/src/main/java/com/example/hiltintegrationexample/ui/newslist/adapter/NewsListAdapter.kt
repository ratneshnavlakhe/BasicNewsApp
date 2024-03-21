package com.example.hiltintegrationexample.ui.newslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hiltintegrationexample.databinding.NewsItemBinding
import com.example.hiltintegrationexample.domain.model.Article

class NewsListAdapter(
    val onItemClick: (item: Article) -> Unit
) : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {
    inner class NewsListViewHolder(
        private val binding: NewsItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article) {
            with(binding) {
                title.text = item.title
                Glide.with(this.root).load(item.urlToImage).into(imageView)
                description.text = item.description
                this.root.setOnClickListener { onItemClick(item) }
            }
        }
    }

    private val diffCallback =
        object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun submitList(list: List<Article>) = differ.submitList(list)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
    }
}
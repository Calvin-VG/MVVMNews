package com.example.mvvmnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmnews.R
import com.example.mvvmnews.model.GetAllNewsResponseItem
import kotlinx.android.synthetic.main.item_news_adapter.view.*

class AdapterNews(private val onClick : (GetAllNewsResponseItem)->Unit): RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    private var newsData : List<GetAllNewsResponseItem>? = null

    fun setNewsList(newsList : List<GetAllNewsResponseItem>){
        this.newsData = newsList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_adapter, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_title_news.text = newsData!![position].title
        holder.itemView.tv_createat_news.text = newsData!![position].createdAt
        holder.itemView.tv_author_news.text = newsData!![position].author

        Glide.with(holder.itemView.context).load(newsData!![position].image).into(holder.itemView.iv_image_news)

        holder.itemView.cv_list_news.setOnClickListener {
            onClick(newsData!![position])
        }
    }

    override fun getItemCount(): Int {
        return if (newsData == null){
            0
        }else{
            newsData!!.size
        }
    }
}
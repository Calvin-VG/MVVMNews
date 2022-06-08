package com.example.mvvmnews.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmnews.R
import com.example.mvvmnews.adapter.AdapterNews
import com.example.mvvmnews.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private lateinit var newsAdapter : AdapterNews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()



    }

    private fun initRecyclerView(){
        rv_list_news.layoutManager = LinearLayoutManager(this)
        newsAdapter = AdapterNews {
            val pindah = Intent(this, DetailNewsActivity::class.java)
            pindah.putExtra("DETAIL_NEWS", it)
            startActivity(pindah)
        }
        rv_list_news.adapter = newsAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLiveDataNews().observe(this) {
            if (it != null) {
                newsAdapter.setNewsList(it)
                newsAdapter.notifyDataSetChanged()
            }
        }
        viewModel.getDataNews()
    }

}
package com.a7pl4y3r.hosts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private val itemList = ArrayList<RecyclerViewItem>()

    private fun setItemList() {
        itemList.add(RecyclerViewItem(R.string.title0, R.string.descr0))
        itemList.add(RecyclerViewItem(R.string.title1, R.string.descr1))
    }

    private fun setRecyclerView() {

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(itemList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setItemList()
        setRecyclerView()
    }
}

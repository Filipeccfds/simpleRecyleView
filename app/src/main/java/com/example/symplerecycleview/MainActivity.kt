package com.example.symplerecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.symplerecycleview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),ListAdapter.listListener {

    private lateinit var binding: ActivityMainBinding
    private val itemList:MutableList<ListItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createMockData()
        var listItem = binding.recycleid
        listItem.layoutManager = LinearLayoutManager(this)
        listItem.adapter = ListAdapter(itemList,this)

    }

    private fun createMockData(){
        itemList.add(ListItem("sao paulo","rs"))
        itemList.add(ListItem("sao paulo","rs"))
        itemList.add(ListItem("sao paulo","rs"))
        itemList.add(ListItem("sao paulo","rs"))
        itemList.add(ListItem("sao paulo","rs"))

    }

    override fun onItemClicked(content: String) {
        Snackbar.make(binding.root,content,Snackbar.LENGTH_SHORT).show()
    }
}
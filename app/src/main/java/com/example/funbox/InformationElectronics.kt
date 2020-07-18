package com.example.funbox

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.funbox.Adapter.ElectronicsAdapter
import com.example.funbox.DataBase.DatsBase



class InformationElectronics {

    fun setList(recyclerView:RecyclerView,context: Context,orientation:Int, type: Int){

        val list = DatsBase().loadFromDB()

        val adapter = ElectronicsAdapter(list,type)
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(context,orientation,false)
        layoutManager.stackFromEnd = false
        layoutManager.isSmoothScrollbarEnabled = true
        recyclerView.layoutManager = layoutManager
    }
}
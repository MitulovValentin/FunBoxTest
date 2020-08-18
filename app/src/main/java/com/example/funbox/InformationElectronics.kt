package com.example.funbox

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.funbox.Adapter.ElectronicsAdapter
import com.example.funbox.DataBase.DataBase



class InformationElectronics {

    fun setList(recyclerView:RecyclerView,context: Context,orientation:Int, type: Int){

        val list = DataBase().loadFromDB()

        val adapter = ElectronicsAdapter(list,type)
        adapter.notifyDataSetChanged()
        recyclerView.adapter = adapter



        val layoutManager = LinearLayoutManager(context,orientation,false)
        if(orientation == LinearLayoutManager.HORIZONTAL) {
            val snapHelper = PagerSnapHelper()
            recyclerView.onFlingListener = null
            snapHelper.attachToRecyclerView(recyclerView)
        }
        recyclerView.layoutManager = layoutManager
    }
}
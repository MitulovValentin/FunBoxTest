package com.example.funbox

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.funbox.Adapter.ElectronicsAdapter
import com.example.funbox.DataBase.DatsBase
import com.example.funbox.Model.Electronics


class InformationElectronics {

    fun setList(recyclerView:RecyclerView,context: Context,orientation:Int, type: Int){

        val list = DatsBase().loadFromDB()

        val adapter = ElectronicsAdapter(list,type)
        adapter.update(list)
        recyclerView.adapter = adapter


        val layoutManager = LinearLayoutManager(context,orientation,false)
        if(orientation == LinearLayoutManager.HORIZONTAL) {
            val snapHelper = PagerSnapHelper()
            recyclerView.onFlingListener = null
            snapHelper.attachToRecyclerView(recyclerView)
        }
      //  layoutManager.stackFromEnd = false
      //  layoutManager.isSmoothScrollbarEnabled = true
        recyclerView.layoutManager = layoutManager
    }
}
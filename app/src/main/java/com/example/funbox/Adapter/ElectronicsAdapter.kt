package com.example.funbox.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.funbox.Model.Electronics
import com.example.funbox.R


class ElectronicsAdapter (private val electronicsList:MutableList<Electronics>, private val type: Int) : RecyclerView.Adapter<ElectronicsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectronicsViewHolder {
         when (type) {
            0 -> {
                val root = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_electronic,parent,false)
                return ElectronicsViewHolder(root)
            }
            else -> {
                val root = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_backend,parent,false)
                return ElectronicsViewHolder(root)
            }
        }
    }

    override fun getItemCount(): Int  = electronicsList.size

    override fun onBindViewHolder(holder: ElectronicsViewHolder, position: Int) {
        when (type) {
            0 -> return holder.bind(electronicsList[position])
            else -> return holder.back(electronicsList[position])
        }
    }

    fun update(electronicsList: MutableList<Electronics>?) {
        electronicsList?.let{
            notifyDataSetChanged()
        }

    }

}


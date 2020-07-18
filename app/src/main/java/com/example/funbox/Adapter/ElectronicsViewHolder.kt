package com.example.funbox.Adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.funbox.Model.Electronics
import com.example.funbox.R
import com.example.funbox.ui.Edit.EditActivity



class ElectronicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.tv_name_id)
    private val priceText: TextView = itemView.findViewById(R.id.tv_price_id)
    private val quantityText: TextView = itemView.findViewById(R.id.tv_quantity_id)


    fun bind(electronic: Electronics) {
        if(electronic.quantity > 0) {
            nameText.text = electronic.name
            priceText.text = electronic.price.toString()
            quantityText.text = electronic.quantity.toString()
        } else {
            itemView.visibility = View.GONE
            itemView.layoutParams = RecyclerView.LayoutParams(0,0)
        }


    }

    fun back (electronic: Electronics) {
        nameText.text = electronic.name
        priceText.text = electronic.price
        quantityText.text = electronic.quantity.toString()

        showEdit(itemView.context,electronic.name,electronic.price,electronic.quantity.toString())
    }

    private fun showEdit (context: Context,name:String,price:String,quantity:String) {
        itemView.setOnClickListener {
            val intent = Intent(context,EditActivity::class.java)
            intent.putExtra("Key_name",name)
            intent.putExtra("Key_price",price)
            intent.putExtra("Key_quantity",quantity)
            context.startActivity(intent)
        }
    }




}
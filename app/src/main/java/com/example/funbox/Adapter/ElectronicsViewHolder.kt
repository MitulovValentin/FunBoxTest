package com.example.funbox.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.funbox.DataBase.DatsBase
import com.example.funbox.Model.Electronics
import com.example.funbox.R
import com.example.funbox.ui.Edit.EditActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_edit.*


class ElectronicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.tv_name_id)
    private val priceText: TextView = itemView.findViewById(R.id.tv_price_id)
    private val quantityText: TextView = itemView.findViewById(R.id.tv_quantity_id)


    fun bind(electronic: Electronics) {
        try{
            nameText.text = electronic.name
            priceText.text = electronic.price
            quantityText.text = electronic.quantity.toString()
            if(electronic.quantity > 0 ) {
                itemView.visibility = View.VISIBLE
                itemView.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
            } else {
                itemView.visibility = View.GONE
                itemView.layoutParams = RecyclerView.LayoutParams(0,0)
            }

            buy(electronic)

        } catch (e: Exception) {
            Log.wtf("TAG 78","bind error")
        }



    }

    fun back (electronic: Electronics) {
        nameText.text = electronic.name
        priceText.text = electronic.price
        quantityText.text = electronic.quantity.toString()

        showEdit(itemView.context,electronic.id,electronic.name,electronic.price,electronic.quantity.toString())
    }

    private fun showEdit (context: Context,id: Int,name:String,price:String,quantity:String) {
        itemView.setOnClickListener {
            val intent = Intent(context,EditActivity::class.java)
            intent.putExtra("Key_id", id)
            intent.putExtra("Key_name",name)
            intent.putExtra("Key_price",price)
            intent.putExtra("Key_quantity",quantity)
            context.startActivity(intent)
        }
    }

    private fun buy(electronics: Electronics) {
        val buttonBuy: Button = itemView.findViewById(R.id.btn_buy)
        buttonBuy.setOnClickListener {
            try{
                val realm = Realm.getDefaultInstance()
                val realmObj = Electronics()
                if(electronics.quantity > 0) {
                    realmObj.id = electronics.id
                    realmObj.name = nameText.text.toString()
                    realmObj.price = priceText.text.toString()
                    realmObj.quantity = quantityText.text.toString().toInt() - 1
                    realm.beginTransaction()
                    realm.copyToRealmOrUpdate(realmObj)
                    realm.commitTransaction()
                    quantityText.text = electronics.quantity.toString()
                } else {
                    Toast.makeText(itemView.context, "Данного товара нет в наличии", Toast.LENGTH_SHORT).show()
                }


            } catch (e: Exception) {
                Log.wtf("TAG77","WTF")
            }
        }
    }


}
package com.example.funbox.Model


import com.example.funbox.DataBase.DatsBase



class ElectronicsObjects()  {

    val obj = Electronics()
    fun getObjects ()  {

        val array = arrayOf(
            arrayOf("Apple iPod touch 5 32Gb", "8888", '5'),
            arrayOf("Samsung Galaxy S Duos S7562", "7230", "2"),
            arrayOf("Canon EOS 600D Kit", "15659", "4"),
            arrayOf("Samsung Galaxy Tab 2 10.1 P5100 16Gb", "13290", "9"),
            arrayOf("PocketBook Touch", "5197", "2"),
            arrayOf("Samsung Galaxy Note || 16Gb", "17049.50", "2"),
            arrayOf("Nikon D3100 Kit", "12190", "4"),
            arrayOf("Canon EOS 1100D Kit", "10985", "2"),
            arrayOf("Sony Xperia acro S", "11800.99", "1"),
            arrayOf("Lenovo G580", "8922", "1")
        )

        for (i in 0 until array.size) {
            obj.name = array[i][0].toString()
            obj.price = array[i][1].toString()
            obj.quantity = array[i][2].toString().toInt()
            DatsBase().saveIntoDB(obj)

        }

    }

}
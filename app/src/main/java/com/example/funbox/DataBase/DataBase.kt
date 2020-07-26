package com.example.funbox.DataBase

import com.example.funbox.Model.Electronics
import io.realm.Realm

class DataBase() {


    fun saveIntoDB(electronics: Electronics){
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(electronics)
        realm.commitTransaction()
    }

    fun loadFromDB () : MutableList<Electronics> {
        val realm = Realm.getDefaultInstance()
        return realm.where(Electronics::class.java).findAll()
    }

}
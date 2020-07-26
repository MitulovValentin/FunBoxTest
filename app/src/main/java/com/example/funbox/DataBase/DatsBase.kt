package com.example.funbox.DataBase

import com.example.funbox.Model.Electronics
import io.realm.Realm
import io.realm.annotations.PrimaryKey


class DatsBase() {


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
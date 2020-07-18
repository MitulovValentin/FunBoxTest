package com.example.funbox.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey



open class Electronics() : RealmObject() {
    @PrimaryKey lateinit var name: String
    lateinit var price: String
    var quantity:Int = 0
}

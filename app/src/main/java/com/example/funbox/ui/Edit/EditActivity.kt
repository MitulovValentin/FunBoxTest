package com.example.funbox.ui.Edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.funbox.Model.Electronics
import com.example.funbox.R
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        realmInit()

        et_name.setText(intent?.extras?.getString("Key_name") ?: "")
        et_price.setText(intent?.extras?.getString("Key_price") ?: "")
        et_quantity.setText(intent?.extras?.getString("Key_quantity") ?: "")

        save()

    }

    fun cancel (view: View) {
        finish()
    }

    fun save() {
        btn_save_id.setOnClickListener {
            try {
                val realm = Realm.getDefaultInstance()
                val realmObj = Electronics()
                realmObj.name = et_name.text.toString()
                realmObj.price = et_price.text.toString()
                realmObj.quantity = et_quantity.text.toString().toInt()
                realm.beginTransaction()
                realm.copyToRealmOrUpdate(realmObj)
                realm.commitTransaction()
            } catch (e: Exception) {
                finish()
            }


            finish()
        }
    }

    fun realmInit() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("dataBase")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }

}
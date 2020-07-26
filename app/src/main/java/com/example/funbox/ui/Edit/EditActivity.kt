package com.example.funbox.ui.Edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.funbox.DataBase.DatsBase
import com.example.funbox.Model.Electronics
import com.example.funbox.R
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    private var firstName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        realmInit()

        val id = intent?.extras?.getInt("Key_id")
        et_name.setText(intent?.extras?.getString("Key_name") ?: "")
        et_price.setText(intent?.extras?.getString("Key_price") ?: "" )
        et_quantity.setText(intent?.extras?.getString("Key_quantity") ?: "")

        firstName =  et_name.text.toString()

        save(id)

    }

    fun cancel (view: View) {
        finish()
    }

    fun save(id: Int?) {
        btn_save_id.setOnClickListener {
            try {
                val realm = Realm.getDefaultInstance()
                val realmObj = Electronics()


                if( id == null ) {
                    realmObj.id = DatsBase().loadFromDB().size + 1
                    if(DatsBase().loadFromDB().joinToString().contains(et_name.text.toString()) && et_name.text.toString() != "" ) {
                        Toast.makeText(this, "Данное название уже существует!", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
                else {
                    realmObj.id = id
                }

                if(et_name.text.toString() == "" || et_price.text.toString() == "" || et_quantity.text.toString() == "" ) {
                    Toast.makeText(this,  "Заполните пустые поля", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (et_name.text.length < 4 ) {
                    Toast.makeText(this,  "Название должно состоять минимум из 4 букв", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                
                realmObj.name = et_name.text.toString()
                if( DatsBase().loadFromDB().joinToString().contains(et_name.text.toString()) && realmObj.name != firstName ) {
                    Toast.makeText(this,  "Данное название уже существует!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                    }
                Log.d("TAG99", realmObj.name)
                Log.d("TAG99", firstName)
                realmObj.price = et_price.text.toString()
                realmObj.quantity = et_quantity.text.toString().toInt()
                realm.beginTransaction()
                realm.copyToRealmOrUpdate(realmObj)
                realm.commitTransaction()
            } catch (e: Exception) {
                return@setOnClickListener
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
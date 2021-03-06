package com.example.funbox

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funbox.DataBase.DataBase
import com.example.funbox.Model.Electronics
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.fragment_store.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

        realmInit()
        getInformation()
    }

    private fun getInformation() {
        try {
            val inputStream = resources.openRawResource(R.raw.data)
            val reader = BufferedReader (InputStreamReader(inputStream, Charset.forName("UTF-8")))
            var line = reader.readLine()
            val obj = Electronics()
            while (line  != null ) {
                Log.d("TAG55", line)
                val tokens = line.split(",")
                obj.id += 1
                obj.name = tokens[0].substring(1)
                obj.price = tokens[1].substring(3,tokens[1].length - 2)
                obj.quantity = tokens[2].substring(3,tokens[2].length - 3).toInt()
                line = reader.readLine()
                if(DataBase().loadFromDB().joinToString().contains("id:${obj.id}")) {
                    Log.d("TAG77", "содержит")
                } else {
                    DataBase().saveIntoDB(obj)
                    Log.d("TAG77", "Не содержит")
                }

            }
        } catch ( e: Exception) {
            e.printStackTrace()
        }
    }

    private fun realmInit() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("dataBase")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }

    override fun onResume() {
        super.onResume()
        realmInit()
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        InformationElectronics().setList(recyclerView_front_id,this,
            LinearLayoutManager.HORIZONTAL,0)

    }
}
package com.example.funbox.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funbox.InformationElectronics
import com.example.funbox.Model.Electronics
import com.example.funbox.R
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_electronic.*

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        InformationElectronics().setList(recyclerView_front_id,view.context,LinearLayoutManager.HORIZONTAL,0)
    }
}
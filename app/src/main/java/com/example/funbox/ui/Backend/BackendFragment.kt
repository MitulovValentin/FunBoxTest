package com.example.funbox.ui.Backend

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funbox.InformationElectronics
import com.example.funbox.R
import com.example.funbox.ui.Edit.EditActivity
import kotlinx.android.synthetic.main.fragment_backend.*

class BackendFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_backend, container, false)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        InformationElectronics().setList(recyclerView_backend_id,view.context,LinearLayoutManager.VERTICAL,1)
        addNewElement(view)
    }

    fun addNewElement(view:View){
        val addButton: ImageButton = view.findViewById(R.id.btn_add_new_element)
        addButton.setOnClickListener {
            val intent = Intent(view.context, EditActivity::class.java)
            view.context.startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        InformationElectronics().setList(recyclerView_backend_id,
            requireContext() ,
            LinearLayoutManager.VERTICAL,
            1)
    }
}
package com.example.funbox.ui.Store


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funbox.InformationElectronics
import com.example.funbox.R
import kotlinx.android.synthetic.main.fragment_store.*

class StoreFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_store, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        InformationElectronics().setList(recyclerView_front_id,view.context,LinearLayoutManager.HORIZONTAL,0)
    }

    override fun onResume() {
        super.onResume()
        InformationElectronics().setList(recyclerView_front_id,requireContext(),LinearLayoutManager.HORIZONTAL,0)
    }
}
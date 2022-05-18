package com.example.myplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.viewModels
import com.example.myplaces.databinding.FragmentListBinding
import com.example.myplaces.model.MyPlacesViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val myPlacesViewModel : MyPlacesViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myPlacesViewModel.myPlacesList = ArrayList<String>()
        myPlacesViewModel.addPlace("Tvrdjava")
        myPlacesViewModel.addPlace("Cair")
        myPlacesViewModel.addPlace("Park Svetog Save")
        myPlacesViewModel.addPlace("Trg Kralja Milana")

        val myPlacesList : ListView = requireView().findViewById<ListView>(R.id.my_places_list)

        myPlacesList.adapter = ArrayAdapter<String>(view.context,android.R.layout.simple_list_item_1, myPlacesViewModel.myPlacesList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
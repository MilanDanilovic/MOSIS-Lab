package com.example.myplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.example.myplaces.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var places: ArrayList<String>
    private lateinit var listView: ListView
    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        places = ArrayList<String>()
        places.add("Tvrdjava")
        places.add("Cair")
        places.add("Park Svetog Save")
        places.add("Trg Kralja Milana")

        listView = requireView().findViewById<ListView>(R.id.my_places_list)

        val adapter = ArrayAdapter<String>(view.context,android.R.layout.simple_list_item_1,places)
        listView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.myplaces.model

import androidx.lifecycle.ViewModel;
import com.example.myplaces.data.MyPlaces

class MyPlacesViewModel : ViewModel() {
    var myPlacesList : ArrayList<MyPlaces> = ArrayList<MyPlaces>()
    fun addPlace(place: MyPlaces){
        myPlacesList.add(place)
    }
    var selected: MyPlaces? =null
}
package com.example.corrutinesfull.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.corrutinesfull.common.model.PokemonResponse

class MainViewModel : ViewModel() {

    val pokemones = MutableLiveData<PokemonResponse>()

    fun obtenerPokemones(limit : Int){

    }

}
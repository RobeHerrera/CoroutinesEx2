package com.example.corrutinesfull.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corrutinesfull.common.model.PokemonResponse
import com.example.corrutinesfull.common.service.ServiceNetwork
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel : ViewModel() {

    // llamamos al servicio
    private val service = ServiceNetwork()

    val pokemones = MutableLiveData<PokemonResponse>()
    val error = MutableLiveData<String>()
    val cargando = MutableLiveData<Boolean>()

    fun obtenerPokemones(limit: Int) {
        viewModelScope.launch {

            cargando.postValue(true)
            try {
                val respuestaPokemones = service.obtenerPokemones(limit)
                if (respuestaPokemones.isSuccessful) {
                    pokemones.postValue(respuestaPokemones.body())
                }
                // Errores de Servidores
                else {
                    error.postValue(respuestaPokemones.errorBody().toString())
                }

                /* when(respuestaPokemones.code()){
                     // Otra forma de validar la respuesta positiva
                     200 -> pokemones.postValue(respuestaPokemones.body())
                     // Otra forma de mandar los errores
                     500 -> error.postValue("error de servidor")
                     404 -> error.postValue("no encontrado")
                 }*/
            // Errores de Hilos u otra cosa
            } catch (err: IOException) {
                error.postValue(err.localizedMessage)
                cargando.postValue(false)
            }
        }
    }

}
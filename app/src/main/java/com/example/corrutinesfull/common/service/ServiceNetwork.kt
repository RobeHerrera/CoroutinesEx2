package com.example.corrutinesfull.common.service

import com.example.corrutinesfull.common.api.ApiClient
import com.example.corrutinesfull.common.api.RetrofitInstance
import com.example.corrutinesfull.common.model.PokemonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ServiceNetwork {

    private val retrofit = RetrofitInstance.getRetrofit().create(ApiClient::class.java)

    suspend fun obtenerPokemones(dato : Int) : Response<PokemonResponse>{
        return withContext(Dispatchers.IO){
            val response = retrofit.obtenerPokemones(dato)
            response
        }

    }

}
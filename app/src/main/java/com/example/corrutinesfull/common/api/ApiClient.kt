package com.example.corrutinesfull.common.api

import com.example.corrutinesfull.common.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("pokemon")
    suspend fun obtenerPokemones(@Query("limit") limit:Int) : Response<PokemonResponse>

}
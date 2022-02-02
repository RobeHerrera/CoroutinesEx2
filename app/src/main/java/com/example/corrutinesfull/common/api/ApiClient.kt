package com.example.corrutinesfull.common.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("pokemon")
    suspend fun obtenerPokemones(@Query("limit") limit:Int)

}
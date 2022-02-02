package com.example.corrutinesfull.common.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PokemonResponse(
    @Expose
    @SerializedName("count")
    var count: Int,

    @Expose
    @SerializedName("next")
    var next : String,

    @Expose
    @SerializedName("results")
    val result: ArrayList<ResultResponse>
)

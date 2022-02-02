package com.example.corrutinesfull.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.corrutinesfull.R
import com.example.corrutinesfull.common.model.PokemonResponse
import com.example.corrutinesfull.ui.main.viewmodel.MainViewModel

class MainActivityView : AppCompatActivity() {
    val viewModel : MainViewModel by viewModels()

    lateinit var button: Button
    lateinit var txt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)

        inicializarComponentes()
        observadores()

        button.setOnClickListener() {
            val numero = 5//txt.text.toString.toInt()
            viewModel.obtenerPokemones(numero)
        }
    }

    private fun observadores() {
        viewModel.pokemones.observe(this,{pokemones ->
            llenarRecyclerView(pokemones)
        })

        viewModel.error.observe(this,{ error ->
            Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
            Log.d("pokemon",error)
        })
    }

    private fun llenarRecyclerView(pokemones: PokemonResponse) {
        pokemones.result.forEach {
            Log.d("pokemon",it.name)
        }
    }

    private fun inicializarComponentes() {
        button = findViewById(R.id.button)
        txt = findViewById(R.id.editTextNumber)
    }
}
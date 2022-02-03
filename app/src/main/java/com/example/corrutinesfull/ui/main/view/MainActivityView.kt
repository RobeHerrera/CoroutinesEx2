package com.example.corrutinesfull.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.corrutinesfull.R
import com.example.corrutinesfull.common.model.PokemonResponse
import com.example.corrutinesfull.ui.main.view.adapter.PokemonAdapter
import com.example.corrutinesfull.ui.main.viewmodel.MainViewModel

class MainActivityView : AppCompatActivity() {
    val viewModel : MainViewModel by viewModels()

    lateinit var button: Button
    lateinit var txt: EditText
    lateinit var  recyclerView: RecyclerView
    lateinit var  progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)

        inicializarComponentes()
        observadores()

        button.setOnClickListener() {
            val numero = txt.text.toString().toInt()
            viewModel.obtenerPokemones(numero)
        }
    }

    private fun observadores() {

        /* Forma 1 de hacer la lambda */
        /*viewModel.pokemones.observe(this) { pokemones ->
            llenarRecyclerView(pokemones)
        }*/

        /* Forma 2 de hacer la lambda */
        viewModel.pokemones.observe(this, this::llenarRecyclerView)

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            Log.d("pokemon", error)
        }

        viewModel.cargando.observe(this) { cargando ->
            cargando(cargando)
        }
    }

    private fun cargando(cargando: Boolean) {
        if (cargando){
            progressBar.visibility = View.VISIBLE
            recyclerView.visibility  = View.GONE
        }else {
            progressBar.visibility = View.GONE
            recyclerView.visibility  = View.VISIBLE
        }
    }

    private fun llenarRecyclerView(pokemones: PokemonResponse) {

        // Only for testing propouses
        /*pokemones.result.forEach {
            Log.d("pokemon",it.name)
        }*/

        val adapter = PokemonAdapter(pokemones.result)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager  = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun inicializarComponentes() {
        button = findViewById(R.id.button)
        txt = findViewById(R.id.editTextNumber)
        recyclerView = findViewById(R.id.recycler)
        progressBar = findViewById(R.id.progressBar)

    }
}
package com.example.corrutinesfull.ui.main.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.corrutinesfull.R
import com.example.corrutinesfull.common.model.ResultResponse

class PokemonAdapter(val data : ArrayList<ResultResponse>) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewPokemon: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textViewPokemon = view.findViewById(R.id.textView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tarjeta_pokemon, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.textViewPokemon.text = data[position].name
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = data.size
}

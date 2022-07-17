package com.gonzalez.blanchard.ejemplorecyclerviewsabado

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PeliculasAdapter (private val mDataSet: Array<Pelicula>,  // Se le pasa el datase con el array de peliculas
                        private val onClickListener: (Pelicula) -> Unit) //Se le pasa el evento click
    : RecyclerView.Adapter<PeliculasViewHolder>() {

    interface OnItemSelectedListener {
        fun onItemSelected(position: Int)
    }


    // El layout manager invoca este método para renderizar cada elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pelicula, parent, false) as LinearLayout
        return PeliculasViewHolder(v)
    }

    // Este método asigna valores para cada elemento de la lista
    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val item = mDataSet[position]
        holder.render(item, onClickListener)
    }

    // Cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejm, si implementamos filtros o búsquedas)
    override fun getItemCount() = mDataSet.size

}
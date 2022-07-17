package com.gonzalez.blanchard.ejemplorecyclerviewsabado

import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.ejemplorecyclerviewsabado.databinding.ItemPeliculaBinding
import com.squareup.picasso.Picasso

class PeliculasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView
    val tvyear: TextView
    val imagenpelicula: ImageView

    //Agregado mediante viewbinding
    val binding = ItemPeliculaBinding.bind(view)

    init {
        // Obtener las referencais mediante viewbinding
        textView = binding.tvname
        tvyear = binding.tvyear
        imagenpelicula = binding.imagenpelicula

        /*
        // Obtener las referencias mediante Find View By Id
        textView = view.findViewById(R.id.tvname)
        tvyear = view.findViewById(R.id.tvyear)
        imagenpelicula = view.findViewById(R.id.imagenpelicula)
        */
    }

    fun render(pelicula:Pelicula, onClickListener: (Pelicula) -> Unit){
        textView.text = pelicula.nombre
        tvyear.text = pelicula.year.toString()
        Picasso.get().load(pelicula.imagen).into(imagenpelicula);

       itemView.setOnClickListener{
           onClickListener(pelicula)
        }

    }

}
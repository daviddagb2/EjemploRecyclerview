package com.gonzalez.blanchard.ejemplorecyclerviewsabado

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.gonzalez.blanchard.ejemplorecyclerviewsabado.databinding.ActivityDetallePeliculasBinding
import com.squareup.picasso.Picasso


class DetallePeliculas : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePeliculasBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePeliculasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val parametros = this.intent.extras
        if (parametros != null) {
            val nombre = parametros.getString("nombre")
            binding.titulo.text = nombre

            val descripcion = parametros.getString("descripcion")
            binding.descripcion.text = descripcion

            val year = parametros.getString("year")
            binding.year.text = "Estrenada en " + year

            val imagen = parametros.getString("imagen")
            Picasso.get().load(imagen).into(binding.imageView);
        }


        //Esto es opcional para poner el action bar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Detalle de pelicula"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
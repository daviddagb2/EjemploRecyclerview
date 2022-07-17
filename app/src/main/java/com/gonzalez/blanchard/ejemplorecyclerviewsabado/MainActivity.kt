package com.gonzalez.blanchard.ejemplorecyclerviewsabado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.ejemplorecyclerviewsabado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val origenDatos = arrayOf(
        Pelicula("Batman", 2022, "Esta pelicula es de batman", "https://i0.wp.com/hipertextual.com/wp-content/uploads/2022/03/batman.jpg?fit=2500%2C1595&quality=50&strip=all&ssl=1"),
        Pelicula("AntMan", 2018, "Esta pelicula es de Antman", "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/4/4f/Ant-Man_and_the_Wasp_-_Promo_Ant-Man.png/revision/latest/top-crop/width/360/height/450?cb=20180716235632&path-prefix=es"),
        Pelicula("Spiderman", 2022, "Esta pelicula es de spiderman", "https://i0.wp.com/hipertextual.com/wp-content/uploads/2020/10/hipertextual-tobey-maguire-y-andrew-garfield-aparecerian-spider-man-3-y-universo-cinematografico-marvel-2020175510.jpg?fit=1200%2C604&quality=50&strip=all&ssl=1"),
        Pelicula("Doctor Strange", 2022, "Esta pelicula es de doctor strange", "https://static.wikia.nocookie.net/marvel/images/2/29/Doctor_Strange_en_el_Multiverso_de_la_Locura_P%C3%B3ster_003.jpg/revision/latest?cb=20220406150939&path-prefix=es"),
        Pelicula("Morbius", 2022, "Esta pelicula es de Morbius", "https://i.blogs.es/b3485e/morbius/840_560.jpeg"),
        Pelicula("Sonic 2", 2022, "Esta pelicula es de Sonic 2", "https://es.web.img3.acsta.net/pictures/22/02/18/10/20/5195258.jpg"),
        Pelicula("Encanto", 2021, "Pelicula Encanto", "https://lumiere-a.akamaihd.net/v1/images/encanto_ka_las_mobile_dda41042.jpeg?region=0,0,1080,1080"),
        Pelicula("Aquaman", 2018, "Esta pelicula es de Aquaman", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDzKeAVXIdPXsC48F6o7Z4aZcEfmcLcbpYg8BZ0Wro2sofKc-wji85U9yZbu8-c5T2VOY&usqp=CAU"),
        Pelicula("Harry Potter y la piedra filosofal", 2001, "Esta pelicula es de Harry Potter", "https://cdn.pocket-lint.com/r/s/1200x630/assets/images/150401-tv-feature-harry-potter-image1-vpdnsqfrou.jpg"),
        Pelicula("El Lobo de wallstreet", 2013, "Esta pelicula es el lobo de wallstreet", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDeacD_obj2lfivwI5YehYbBft1_OIDJxoPe9YLNtYiIBqydtYnzuzOc_DnsO2SowRfxA&usqp=CAU"),
        Pelicula("Titanic", 1997, "Esta pelicula es de Titanic", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2YDCBoBPIAM9jlGf5zrfRnyGJe6M-kUlnZDkNRAKDy5zPw9UU_Olvyh2j4LHGZ59OAsY&usqp=CAU"),
        Pelicula("Rapidos y furiosos 9", 2021, "Esta pelicula es de rapido y furioso 9", "https://mx.web.img3.acsta.net/pictures/21/04/14/17/28/5059871.jpg"),
        )


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //esto pone hola mundo en el texto
        binding.textotitulo.text = "Hola mundo"

        //Para mover la logica del recyclerview a una funcion
        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.listapeliculas.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(baseContext)
        binding.listapeliculas.layoutManager = layoutManager
        //set adapter
        binding.listapeliculas.adapter =  PeliculasAdapter(origenDatos) { onItemClick(it) }
    }

    private fun onItemClick(pelicula: Pelicula) {
        //Toast.makeText(binding.imagenpelicula.context, "Nombre " + pelicula.nombre, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetallePeliculas::class.java).apply {
            putExtra("nombre", pelicula.nombre)
            putExtra("year", "" + pelicula.year)
            putExtra("imagen", pelicula.imagen)
            putExtra("descripcion", pelicula.descripcion)
        }
        startActivity(intent)
    }

}
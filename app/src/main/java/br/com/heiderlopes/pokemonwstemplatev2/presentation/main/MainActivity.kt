package br.com.heiderlopes.pokemonwstemplatev2.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityMainBinding
import br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons.ListPokemonsActivity
import br.com.heiderlopes.pokemonwstemplatev2.presentation.scan.ScanActivity

class MainActivity : AppCompatActivity() {

    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val btPokemonList = findViewById<Button>(R.id.btPokemonList)

        btPokemonList.setOnClickListener {
            val listPokemonsIntent = Intent(this, ListPokemonsActivity::class.java)
            startActivity(listPokemonsIntent)
        }

        viewBinding.btPokedex.setOnClickListener {
            startActivity(Intent(this, ScanActivity::class.java))
       }
    }
}
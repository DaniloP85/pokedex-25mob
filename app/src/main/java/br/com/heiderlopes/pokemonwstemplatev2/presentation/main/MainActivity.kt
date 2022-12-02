package br.com.heiderlopes.pokemonwstemplatev2.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons.ListPokemonsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btPokemonList = findViewById<Button>(R.id.btPokemonList)

        btPokemonList.setOnClickListener {
            val listPokemonsIntent = Intent(this, ListPokemonsActivity::class.java)
            startActivity(listPokemonsIntent)
        }
    }
}
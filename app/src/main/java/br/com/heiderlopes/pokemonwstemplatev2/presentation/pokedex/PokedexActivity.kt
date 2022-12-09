package br.com.heiderlopes.pokemonwstemplatev2.presentation.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityPokedexBinding
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.ViewState
import br.com.heiderlopes.pokemonwstemplatev2.presentation.scan.ScanActivityViewModel
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class PokedexActivity : AppCompatActivity() {

    private val viewBinding by lazy { ActivityPokedexBinding.inflate(layoutInflater) }
    private val picasso: Picasso by inject()
    private val viewModel : ScanActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val number = intent.getStringExtra("POKEMON") ?: ""
        viewModel.getPokemon(number)

        registerObserva()
    }

    private fun registerObserva() {
        viewModel.pokemonResult.observe(this){
            when(it){
                is ViewState.Success -> {
                    viewBinding.tvPokemonName.text = it.data.name
                    Log.d("dpsnqmk", "${it.data}")
                    picasso
                        .load("https://pokedexdx.herokuapp.com${it.data.imageURL}")
                        .placeholder(R.drawable.logo_pokemon)
                        .into(viewBinding.ivPokemon)
                }
            }
        }
    }
}
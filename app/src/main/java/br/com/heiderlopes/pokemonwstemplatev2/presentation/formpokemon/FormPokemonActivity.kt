package br.com.heiderlopes.pokemonwstemplatev2.presentation.formpokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityFormPokemonBinding
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.ViewState
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class FormPokemonActivity : AppCompatActivity() {

    private val formPokemonViewModel: FormPokemonViewModel by viewModel()
    private val picasso: Picasso by inject()
    private lateinit var pokemon: Pokemon

    private val viewBinding by lazy { ActivityFormPokemonBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val pokemonNumber = intent.getStringExtra("POKEMON") ?: ""
        formPokemonViewModel.getPokemon(pokemonNumber)
        registerObserver()
        updatePokemon()
    }

    private fun updatePokemon() =
        viewBinding.btSaveForm.setOnClickListener {
            pokemon.attack = viewBinding.sbAttack.progress
            pokemon.defense = viewBinding.sbDefense.progress
            pokemon.velocity = viewBinding.sbVelocity.progress
            pokemon.ps = viewBinding.sbPS.progress
            formPokemonViewModel.update(pokemon)
        }

    private fun registerObserver() {
        formPokemonViewModel.pokemonResult.observe(this) {
            when(it) {
                is ViewState.Success -> setValues(it.data)
                is ViewState.Failure -> {
                    Toast.makeText(this, it.throwable.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        formPokemonViewModel.pokemonUpdateResult.observe(this) {
            when(it) {
                is ViewState.Success -> {
                    Toast.makeText(
                        this,
                        "Pokémon atualizado com sucesso",
                        Toast.LENGTH_LONG).show()
                }

                is ViewState.Failure -> {
                    Toast.makeText(this, it.throwable.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    private fun setValues(pokemon: Pokemon) {
        this.pokemon = pokemon
        viewBinding.tvPokemonNameForm.text = pokemon.name

        picasso
            .load("https://pokedexdx.herokuapp.com${pokemon.imageURL}")
            .placeholder(R.drawable.logo_pokemon)
            .into(viewBinding. ivPokemonForm)

        viewBinding.sbAttack.progress = pokemon.attack
        viewBinding.sbDefense.progress = pokemon.defense
        viewBinding.sbPS.progress = pokemon.ps
        viewBinding.sbVelocity.progress = pokemon.velocity

        viewBinding.tvAttackValue.text = pokemon.attack.toString()
        viewBinding.tvDefenseValue.text = pokemon.defense.toString()
        viewBinding.tvPSValue.text = pokemon.ps.toString()
        viewBinding.tvVelocityValue.text = pokemon.velocity.toString()

        setListener(viewBinding.sbAttack, viewBinding.tvAttackValue)
        setListener(viewBinding.sbDefense, viewBinding.tvDefenseValue)
        setListener(viewBinding.sbVelocity, viewBinding.tvVelocityValue)
        setListener(viewBinding.sbPS, viewBinding.tvPSValue)
    }

    private fun setListener(seekBar: SeekBar, textView: TextView) {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?,
                                           progress: Int,
                                           fromUser: Boolean) {
                textView.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}
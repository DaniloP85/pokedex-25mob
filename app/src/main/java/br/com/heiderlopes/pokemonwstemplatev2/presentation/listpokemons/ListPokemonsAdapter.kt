package br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.heiderlopes.pokemonwstemplatev2.databinding.PokemonListItemBinding
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import com.squareup.picasso.Picasso


class ListPokemonsAdapter(val pokemons: List<Pokemon>, val picasso: Picasso, val clickListener: (Pokemon) -> Unit) : RecyclerView.Adapter<ListPokemonsAdapter.PokemonViewHolder>() {
    inner class PokemonViewHolder(val binding: PokemonListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            PokemonListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.binding.tvPokemonName.text = pokemon.name
        holder.binding.tvPokemonNumber.text = pokemon.number
        picasso.load("https://pokedexdx.herokuapp.com/${pokemon.imageURL}")
            .into(holder.binding.ivPokemon)

        holder.binding.ivPokemon.setOnClickListener {
            clickListener(pokemon)
        }
    }

    override fun getItemCount() = pokemons.size
}
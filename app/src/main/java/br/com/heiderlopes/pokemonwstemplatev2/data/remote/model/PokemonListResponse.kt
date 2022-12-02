package br.com.heiderlopes.pokemonwstemplatev2.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("content")val pokemons: List<PokemonResponse>
)
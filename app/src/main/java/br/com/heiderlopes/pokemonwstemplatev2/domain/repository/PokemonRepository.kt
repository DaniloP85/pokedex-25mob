package br.com.heiderlopes.pokemonwstemplatev2.domain.repository

import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemons(
        size: Int,
        sort: String
    ): Result<List<Pokemon>>

    suspend fun getPokemon(
        number: String
    ): Result<Pokemon>

    suspend fun update(
        pokemon: Pokemon
    ): Result<Pokemon>
}
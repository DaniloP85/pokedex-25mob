package br.com.heiderlopes.pokemonwstemplatev2.data.remote.mapper

import br.com.heiderlopes.pokemonwstemplatev2.data.remote.model.PokemonResponse
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.utils.Mapper

class PokemonResponseListToPokemonListMapper :
    Mapper<List<PokemonResponse>, List<Pokemon>> {
    private val mapper = PokemonResponseToPokemonMapper()
    override fun map(source: List<PokemonResponse>): List<Pokemon> = source.map { mapper.map(it) }
}
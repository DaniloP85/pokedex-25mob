package br.com.heiderlopes.pokemonwstemplatev2.data.repository

import br.com.heiderlopes.pokemonwstemplatev2.data.remote.api.PokemonService
import br.com.heiderlopes.pokemonwstemplatev2.data.remote.mapper.PokemonResponseListToPokemonListMapper
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.repository.PokemonRepository

class PokemonRepositoryImpl( private val pokemonService: PokemonService) : PokemonRepository {
    private val pokemonListMapper: PokemonResponseListToPokemonListMapper = PokemonResponseListToPokemonListMapper()

    override suspend fun getPokemons(size: Int, sort: String):
            Result<List<Pokemon>> {
        return Result.success(pokemonListMapper.map(pokemonService.getPokemons(size, sort).pokemons)
        )
    }
}
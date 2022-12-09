package br.com.heiderlopes.pokemonwstemplatev2.domain.usecase

import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.repository.PokemonRepository

class UpdatePokemonUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(pokemon: Pokemon) = pokemonRepository.update(pokemon)
}
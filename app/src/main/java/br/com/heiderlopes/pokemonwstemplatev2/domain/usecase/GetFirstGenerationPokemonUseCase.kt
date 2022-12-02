package br.com.heiderlopes.pokemonwstemplatev2.domain.usecase

import br.com.heiderlopes.pokemonwstemplatev2.domain.repository.PokemonRepository

class GetFirstGenerationPokemonsUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke() = pokemonRepository.getPokemons(
        150,
        "number,asc"
    )
}
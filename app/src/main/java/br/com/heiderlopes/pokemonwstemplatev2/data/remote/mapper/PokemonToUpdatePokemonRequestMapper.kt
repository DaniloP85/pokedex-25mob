package br.com.heiderlopes.pokemonwstemplatev2.data.remote.mapper

import br.com.heiderlopes.pokemonwstemplatev2.data.remote.model.UpdatePokemonRequest
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.utils.Mapper

class PokemonToUpdatePokemonRequestMapper : Mapper<Pokemon, UpdatePokemonRequest> {
    override fun map(source: Pokemon): UpdatePokemonRequest {
        return UpdatePokemonRequest(
            number = source.number,
            name = source.name,
            imageURL = source.imageURL,
            ps = source.ps,
            attack = source.attack,
            defense = source.defense,
            velocity = source.velocity,
        )
    }
}
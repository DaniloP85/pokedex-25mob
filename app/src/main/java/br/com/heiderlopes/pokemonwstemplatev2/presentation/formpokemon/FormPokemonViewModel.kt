package br.com.heiderlopes.pokemonwstemplatev2.presentation.formpokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.ViewState
import br.com.heiderlopes.pokemonwstemplatev2.domain.usecase.GetPokemonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FormPokemonViewModel(
    val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {
    private val _pokemonResult =
        MutableLiveData<ViewState<Pokemon>>()
    val pokemonResult : LiveData<ViewState<Pokemon>>
        get() = _pokemonResult
    fun getPokemon(number: String) {
        _pokemonResult .postValue( ViewState.Loading)
        viewModelScope.launch(Dispatchers .IO) {
            runCatching {
                getPokemonUseCase (number)
            }.onSuccess {

                _pokemonResult .postValue( ViewState.Success(it.getOrDefault(Pokemon("",
                    "", "", 0,0,0,0))))
            }.onFailure {
                _pokemonResult .postValue( ViewState.Failure(it))
            }
        }
    }
}
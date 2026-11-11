package zamudio.ramon.pokedexprueba.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import zamudio.ramon.pokedexprueba.model.data.CompanionPreferences
import zamudio.ramon.pokedexprueba.model.data.getPokemonByNumber
import zamudio.ramon.pokedexprueba.model.data.pokemonList
import zamudio.ramon.pokedexprueba.model.domain.Pokemon

class PokemonDetailViewModel(private val companionDataStore: CompanionPreferences): ViewModel() {
    val pokemonCompanion: Flow<Pokemon> = companionDataStore.pokemonCompanion()
    private val _uiEvent = MutableSharedFlow<String>()
    val uiEvent: SharedFlow<String> = _uiEvent.asSharedFlow()
    fun saveCompanion(pokemon: Pokemon){
        viewModelScope.launch {
            companionDataStore.saveCompanion(pokemon)
            _uiEvent.emit("Compañero seleccionado")
        }
    }

    fun getPokemon(id: Int): Pokemon{
        return getPokemonByNumber(id)
    }

    fun getAntAndSig(id: Int): Pair<Pokemon, Pokemon>{
        return getAntAndSig(id)
    }

    fun quitarAgregarFav(id: Int){
        var pokemon:Pokemon = getPokemon(id)
        if(pokemon.favorite){
            pokemon.favorite = false
        }else{
            pokemon.favorite = true
        }
    }

}
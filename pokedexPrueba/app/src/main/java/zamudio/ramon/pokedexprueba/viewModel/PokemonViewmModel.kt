package zamudio.ramon.pokedexprueba.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import zamudio.ramon.pokedexprueba.model.domain.Pokemon

class PokemonViewmModel: ViewModel(){
    var wildPokemon by mutableStateOf<Pokemon?>(null)

    fun capturePokemon(){

    }
}
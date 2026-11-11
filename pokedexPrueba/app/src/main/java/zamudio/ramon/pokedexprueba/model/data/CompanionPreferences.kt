package zamudio.ramon.pokedexprueba.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import zamudio.ramon.pokedexprueba.model.domain.Pokemon
import zamudio.ramon.pokedexprueba.model.references.PokemonSerializer

val Context.dataStore: DataStore<Pokemon> by dataStore(
    fileName = "pokemon.json",
    serializer = PokemonSerializer,
    scope = CoroutineScope(Dispatchers.IO )
)

class CompanionPreferences(private val context: Context){
    suspend fun saveCompanion(companion: Pokemon){
        context.dataStore.updateData {
            pokemon -> companion
        }
    }
    fun pokemonCompanion(): Flow<Pokemon> = context.dataStore.data.map{
        pokemon -> pokemon
    }
}
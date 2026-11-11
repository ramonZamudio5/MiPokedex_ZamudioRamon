package zamudio.ramon.pokedexprueba.model.references

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import kotlinx.serialization.json.Json
import zamudio.ramon.pokedexprueba.R
import zamudio.ramon.pokedexprueba.model.domain.Pokemon
import java.io.InputStream
import java.io.OutputStream

object PokemonSerializer: Serializer<Pokemon>{
    override val defaultValue: Pokemon = Pokemon(
        name = "",
        number = -1,
        type = "",
        "",
        height = 0f,
        weight = 0f,
        favorite = false,
        ability = "",
        image = R.drawable.wtp
    )

    override suspend fun readFrom(input: InputStream): Pokemon {
        return try {
            Json.decodeFromString(
                Pokemon.serializer(),input.readBytes().decodeToString()
            )
        }catch (eception: Exception){
            throw CorruptionException("No se pudo leer el json", eception)
        }
    }

    override suspend fun writeTo(
        t: Pokemon,
        output: OutputStream
    ) {
        output.write(
            Json.encodeToString(Pokemon.serializer(),t).encodeToByteArray()
        )
    }

}
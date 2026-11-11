package zamudio.ramon.pokedexprueba.model.domain

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(val name: String,
                   val number: Int,
                   val type:String,
                   val descripcion: String,
                   val height: Float,
                   val weight: Float,
                   var favorite: Boolean,
                   val ability: String,
                   val image: Int) {


}
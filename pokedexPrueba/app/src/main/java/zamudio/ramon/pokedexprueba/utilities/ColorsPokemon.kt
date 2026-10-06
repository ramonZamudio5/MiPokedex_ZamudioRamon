package zamudio.ramon.pokedexprueba.utilities

import androidx.compose.ui.graphics.Color
import zamudio.ramon.pokedexprueba.ui.theme.Bug
import zamudio.ramon.pokedexprueba.ui.theme.DarkGray
import zamudio.ramon.pokedexprueba.ui.theme.Electric
import zamudio.ramon.pokedexprueba.ui.theme.Fairy
import zamudio.ramon.pokedexprueba.ui.theme.Fight
import zamudio.ramon.pokedexprueba.ui.theme.Fire
import zamudio.ramon.pokedexprueba.ui.theme.Flying
import zamudio.ramon.pokedexprueba.ui.theme.Ghost
import zamudio.ramon.pokedexprueba.ui.theme.Grass
import zamudio.ramon.pokedexprueba.ui.theme.Ground
import zamudio.ramon.pokedexprueba.ui.theme.Normal
import zamudio.ramon.pokedexprueba.ui.theme.OffWhite
import zamudio.ramon.pokedexprueba.ui.theme.Poison
import zamudio.ramon.pokedexprueba.ui.theme.Psych
import zamudio.ramon.pokedexprueba.ui.theme.Rock
import zamudio.ramon.pokedexprueba.ui.theme.Water

private val listaOffWhite = listOf<String>("Normal","Water","Fire","Psych","Ghost","Bug","Poison","Grass",
    "Ground","Rock")
private val listDarkGray = listOf<String>("Electric","Fairy","Fight","Flying")
private val mapaColores = mapOf<String, Color>("Normal" to Normal,"Water" to Water, "Fire" to Fire, "Psych" to Psych,
    "Ghost" to Ghost, "Bug" to Bug, "Poison" to Poison, "Grass" to Grass, "Ground" to Ground, "Rock" to Rock,
    "Electric" to Electric,"Fairy" to Fairy,"Fight" to Fight,"Flying" to Flying)

fun ColorPokemon(tipo:String): Pair<Color, Color>{
    if(listaOffWhite.contains(tipo)){
        return  mapaColores.getValue(tipo) to OffWhite
    }else{
        return  mapaColores.getValue(tipo) to DarkGray
    }
}
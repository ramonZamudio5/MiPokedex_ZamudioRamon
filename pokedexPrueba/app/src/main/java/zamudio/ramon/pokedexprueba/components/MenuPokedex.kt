package zamudio.ramon.pokedexprueba.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import zamudio.ramon.pokedexprueba.Greeting
import zamudio.ramon.pokedexprueba.Pokedex
import zamudio.ramon.pokedexprueba.data.pokemonList
import zamudio.ramon.pokedexprueba.domain.Pokemon
import zamudio.ramon.pokedexprueba.ui.theme.PokedexPruebaTheme

class menupokedex : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexPruebaTheme {
                MenuPokedex(pokemonList)
            }
        }
    }
}
@Composable
fun MenuPokedex(pokemonList:List<Pokemon>){
    LazyColumn() {
        items(pokemonList){
                pokemonn -> PokemonRow(pokemonn)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun preview(){
    MenuPokedex(pokemonList)
}
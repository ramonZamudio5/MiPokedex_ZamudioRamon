package zamudio.ramon.pokedexprueba.components

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                pokemon -> PokemonRow(pokemon)
        }
    }
}

@Composable
fun FavoritesRows(favoritesList:List<Pokemon>, onNavigateDetail : (id:Int)-> Unit){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(favoritesList){
                pokemon -> FavoritePokemon(pokemon, onNavigateDetail)
        }
    }
}

@Composable
fun PokedexGrid(pokemonList:List<Pokemon>){
    LazyVerticalGrid(columns = GridCells.Fixed(3), contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(pokemonList) {
            pokemon -> PokemonCell(pokemon = pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview(){
    PokedexGrid(pokemonList)
}
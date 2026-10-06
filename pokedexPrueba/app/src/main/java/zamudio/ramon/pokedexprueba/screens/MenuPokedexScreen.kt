package zamudio.ramon.pokedexprueba.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zamudio.ramon.pokedexprueba.Greeting
import zamudio.ramon.pokedexprueba.components.FavoritePokemon
import zamudio.ramon.pokedexprueba.components.FavoritesRows
import zamudio.ramon.pokedexprueba.components.PokedexGrid
import zamudio.ramon.pokedexprueba.data.getFavoritesPokemons
import zamudio.ramon.pokedexprueba.data.pokemonList
import zamudio.ramon.pokedexprueba.domain.Pokemon
import zamudio.ramon.pokedexprueba.ui.theme.PokedexPruebaTheme

class MenuPokedexScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexPruebaTheme {
                MenuPokedexScreen(PaddingValues(10.dp,15.dp)) { }
            }
        }
    }
}

@Composable
fun MenuPokedexScreen(innerPadding : PaddingValues, onNavigateDetail: (id:Int)->Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Mis Favoritos", fontSize = 22.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp))
        FavoritesRows(getFavoritesPokemons(),onNavigateDetail)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Todos mis pokemones", fontSize = 22.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp))
        PokedexGrid(pokemonList = pokemonList)
    }
}


@Preview(showBackground = true)
@Composable
fun previewMenuPokedex(){
    MenuPokedexScreen(PaddingValues(10.dp,15.dp)) { }
}


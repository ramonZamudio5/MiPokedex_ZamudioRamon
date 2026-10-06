package zamudio.ramon.pokedexprueba.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zamudio.ramon.pokedexprueba.data.bulbasaur
import zamudio.ramon.pokedexprueba.screens.MenuPokedexScreen
import zamudio.ramon.pokedexprueba.screens.pokemonInfo

@Composable
fun Myapp(innerPadding : PaddingValues){
    val navcController = rememberNavController()
    NavHost(navcController, startDestination = PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateDetail = {id->navcController.navigate(route = PokemonDetail(id))})
        }
        composable<PokemonDetail> {

        }
    }

}
package zamudio.ramon.pokedexprueba.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zamudio.ramon.pokedexprueba.model.data.getAntAndSig
import zamudio.ramon.pokedexprueba.model.data.getPokemonByNumber
import zamudio.ramon.pokedexprueba.view.screens.MenuPokedexScreen
import zamudio.ramon.pokedexprueba.view.screens.pokemonInfo

@Composable
fun Myapp(innerPadding : PaddingValues){
    val navcController = rememberNavController()
    NavHost(navcController, startDestination = PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateDetail = {id->navcController.navigate(route = PokemonDetail(id))})
        }
        composable<PokemonDetail> {
            val pokemon = it.arguments?.getInt("pokemon") ?:-1
            pokemonInfo(getPokemonByNumber(pokemon), getAntAndSig(pokemon).second,getAntAndSig(pokemon).first,innerPadding)
        }
    }

}
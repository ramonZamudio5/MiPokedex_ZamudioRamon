package zamudio.ramon.pokedexprueba.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zamudio.ramon.pokedexprueba.model.data.Users
import zamudio.ramon.pokedexprueba.model.data.getAntAndSig
import zamudio.ramon.pokedexprueba.model.data.getPokemonByNumber
import zamudio.ramon.pokedexprueba.view.screens.LoginScreen
import zamudio.ramon.pokedexprueba.view.screens.MenuPokedexScreen
import zamudio.ramon.pokedexprueba.view.screens.PokemonHuntScreen
import zamudio.ramon.pokedexprueba.view.screens.pokemonInfo
import zamudio.ramon.pokedexprueba.viewModel.UserViewModel

@Composable
fun Myapp(innerPadding : PaddingValues, userviewModel: UserViewModel){
    val navcController = rememberNavController()
    val navigateToMenu = {
        navcController.navigate(PokemonList)
    }
    val navigateToDetail = {id: Int ->navcController.navigate(route = PokemonDetail(id))}
    NavHost(navcController, startDestination = Login){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateDetail = navigateToDetail,
                onNavigateHunt = {navcController.navigate(route = PokemonHunt)},{
                    userviewModel.logOut()
                    navcController.navigate(Login) {
                        popUpTo(0) {
                            inclusive = true
                        }}
                })
        }
        composable<PokemonDetail> {
            val pokemon = it.arguments?.getInt("pokemon") ?:-1
            pokemonInfo(getPokemonByNumber(pokemon), getAntAndSig(pokemon).second,getAntAndSig(pokemon).first,innerPadding)
        }
        composable<PokemonHunt>{
            PokemonHuntScreen(innerPadding, onNAvigateToDetail = navigateToDetail)
        }
        composable<Login> {
            LoginScreen(innerPadding, userviewModel ,onNavigateToMenu = navigateToMenu)
        }
    }

}
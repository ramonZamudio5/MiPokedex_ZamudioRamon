package zamudio.ramon.pokedexprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zamudio.ramon.pokedexprueba.model.data.CompanionPreferences
import zamudio.ramon.pokedexprueba.model.data.Users
import zamudio.ramon.pokedexprueba.model.domain.Pokemon
import zamudio.ramon.pokedexprueba.navigation.Myapp
import zamudio.ramon.pokedexprueba.ui.theme.PokedexPruebaTheme
import zamudio.ramon.pokedexprueba.view.screens.LoginScreen
import zamudio.ramon.pokedexprueba.viewModel.PokemonDetailViewModel
import zamudio.ramon.pokedexprueba.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = Users(this)

        val companionPreferences = CompanionPreferences(this)
        val pokemonDetailViewModel = PokemonDetailViewModel(companionPreferences)
        val usersViewModel = UserViewModel(users,companionPreferences)
        enableEdgeToEdge()
        setContent {
            PokedexPruebaTheme {
                Myapp(PaddingValues(10.dp,15.dp),usersViewModel,pokemonDetailViewModel)
            }
        }
    }
}




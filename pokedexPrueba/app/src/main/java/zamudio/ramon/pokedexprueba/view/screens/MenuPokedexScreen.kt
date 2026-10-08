package zamudio.ramon.pokedexprueba.view.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zamudio.ramon.pokedexprueba.R
import zamudio.ramon.pokedexprueba.view.components.FavoritesRows
import zamudio.ramon.pokedexprueba.view.components.PokedexGrid
import zamudio.ramon.pokedexprueba.model.data.getFavoritesPokemons
import zamudio.ramon.pokedexprueba.model.data.pokemonList
import zamudio.ramon.pokedexprueba.ui.theme.Blue
import zamudio.ramon.pokedexprueba.ui.theme.Green
import zamudio.ramon.pokedexprueba.ui.theme.PokedexPruebaTheme
import zamudio.ramon.pokedexprueba.view.components.MenuPokedex
import zamudio.ramon.pokedexprueba.view.components.menupokedex

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
    var grid by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Mis Favoritos", fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 10.dp))
        FavoritesRows(getFavoritesPokemons(),onNavigateDetail)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Todos mis Pokemon's", fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 10.dp))
        Switch(checked = grid, onCheckedChange = { grid = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Green,
                checkedTrackColor = LightGray,
                uncheckedThumbColor = Blue,
                uncheckedTrackColor = LightGray,
                uncheckedBorderColor = Transparent
            ),
            thumbContent = if (grid) {
                {
                    Icon(painterResource(id = R.drawable.gridd), contentDescription = "grid icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize))
                }
            } else {
                {
                    Icon(painterResource(id = R.drawable.rows), contentDescription = "list icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize))
                }
            }
        )
        if (grid) {
            PokedexGrid(pokemonList)
        } else {
            MenuPokedex(pokemonList)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun previewMenuPokedex(){
    MenuPokedexScreen(PaddingValues(10.dp,15.dp)) { }
}


package zamudio.ramon.pokedexprueba.view.screens

import android.R
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import zamudio.ramon.pokedexprueba.ui.theme.Fairy
import zamudio.ramon.pokedexprueba.ui.theme.Green
import zamudio.ramon.pokedexprueba.ui.theme.Purple40
import zamudio.ramon.pokedexprueba.ui.theme.Purple80
import zamudio.ramon.pokedexprueba.ui.theme.Typography
import zamudio.ramon.pokedexprueba.view.components.PokemonRow
import zamudio.ramon.pokedexprueba.viewModel.PokemonViewmModel

@Composable
fun PokemonHuntScreen(innerPadding: PaddingValues,viewModel : PokemonViewmModel = viewModel(), onNAvigateToDetail :(id: Int)->Unit){
    Column(Modifier
        .fillMaxWidth()
        .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {viewModel.searchPokemon()}) {
            Text("Buscar Pokemon en la hierva")
        }
        Spacer(Modifier.size(18.dp))
        viewModel.wildPokemon?.let {
            pokemon ->
            Text("aparecio un ${pokemon.name} salvaje", style = Typography.labelLarge, color = Purple40)
            Image(painterResource(pokemon.image), contentDescription = "${pokemon.name} image")
            Spacer(Modifier.size(15.dp))
            Button(onClick = {viewModel.capturePokemon()}) {
                Text("capturar a ${pokemon.name}")
            }
            if(viewModel.gonePokemon) {
                Text("El pokemon se ah escapado😓", style = Typography.labelLarge, color = Color.Magenta
                )
            }
            if(viewModel.isPokemonCaptured){
                Text("Has atrapado al pokoemon🤗",style = Typography.labelLarge, color = Green)
            }
            Spacer(Modifier.size(20.dp))

            Text("pokemones capturados", style = Typography.titleLarge, color = Fairy)
            LazyColumn() {
                items(viewModel.capturedPokemon){
                    pokemon ->
                    PokemonRow(pokemon)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview(){
    PokemonHuntScreen(PaddingValues(15.dp), onNAvigateToDetail = {})
}
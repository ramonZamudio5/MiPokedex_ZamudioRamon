package zamudio.ramon.pokedexprueba.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zamudio.ramon.pokedexprueba.data.bulbasaur
import zamudio.ramon.pokedexprueba.domain.Pokemon
import zamudio.ramon.pokedexprueba.ui.theme.Green

@Composable
fun PokemonRow(pokemon : Pokemon){
    Row(Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painterResource(pokemon.image), contentDescription = "${pokemon.name}+image",
            Modifier.width(80.dp).padding(10.dp))
        Column(Modifier.fillMaxWidth(0.70f),verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(pokemon.name,style = MaterialTheme.typography.labelLarge)
            Text(pokemon.descripcion, fontSize = 10.sp)
            Row(Modifier.fillMaxWidth(.85f), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("height: ${pokemon.height}",style = MaterialTheme.typography.labelMedium)
                Text("Wheight: ${pokemon.weight}",style = MaterialTheme.typography.labelMedium)
            }
        }
        Text("${pokemon.number}", Modifier.background(Green, CircleShape).padding(5.dp,2.dp).align(
            Alignment.Top))
    }

}



@Preview(showBackground = true)
@Composable
fun PokemonElementPreview(){
    PokemonRow(bulbasaur)
}
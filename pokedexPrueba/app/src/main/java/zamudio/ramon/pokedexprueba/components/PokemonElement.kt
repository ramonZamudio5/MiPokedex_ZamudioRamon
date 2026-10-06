package zamudio.ramon.pokedexprueba.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zamudio.ramon.pokedexprueba.data.bulbasaur
import zamudio.ramon.pokedexprueba.domain.Pokemon
import zamudio.ramon.pokedexprueba.ui.theme.Green
import zamudio.ramon.pokedexprueba.ui.theme.OffWhite
import zamudio.ramon.pokedexprueba.utilities.ColorPokemon

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
        NumberChip(pokemon.number.toString(),(ColorPokemon(pokemon.type)))
    }

}

@Composable
fun FavoritePokemon(pokemon : Pokemon,onNavigationDetail:(id:Int)-> Unit){
    val colors = ColorPokemon(pokemon.type)
    Column(Modifier.padding(vertical = 15.dp).clickable(true, onClick = {onNavigationDetail(pokemon.number as Int)}),verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Box(){
            Box(Modifier.border(border = BorderStroke(width = 5.dp,
                brush = Brush.sweepGradient(
                    listOf(
                        colors.first,
                        OffWhite,
                        colors.first,
                        OffWhite,
                        colors.first
                    ))), shape = RoundedCornerShape(16.dp))){
                Image(painterResource(pokemon.image), contentDescription = "${pokemon.name}+image",
                    Modifier.padding(5.dp).width(75.dp).height(75.dp))
            }
            NumberChip(pokemon.number.toString(),ColorPokemon(pokemon.type), modifier = Modifier.align(
                Alignment.BottomEnd))
        }
    }
}

@Composable
fun PokemonCell(pokemon:Pokemon){
    Column(Modifier.padding(vertical = 15.dp).background(OffWhite),verticalArrangement = Arrangement.spacedBy(10.dp),) {
        Box(){
            Box(){
                Image(painterResource(pokemon.image), contentDescription = "${pokemon.name}+image",
                    Modifier.padding(10.dp).width(150.dp).height(150.dp))
            }
            NumberChip(pokemon.number.toString(),ColorPokemon(pokemon.type), modifier = Modifier.align(
                Alignment.TopEnd))
        }
        Text(pokemon.name, Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.Black)
    }
}



@Preview(showBackground = false)
@Composable
fun PokemonElementPreview(){
   
}
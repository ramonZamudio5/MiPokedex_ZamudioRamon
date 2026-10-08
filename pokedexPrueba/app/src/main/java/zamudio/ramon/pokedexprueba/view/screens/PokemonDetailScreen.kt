package zamudio.ramon.pokedexprueba.view.screens
import androidx.compose.runtime.Composable
import zamudio.ramon.pokedexprueba.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zamudio.ramon.pokedexprueba.model.data.bulbasaur
import zamudio.ramon.pokedexprueba.model.data.pokemonList
import zamudio.ramon.pokedexprueba.model.domain.Pokemon
import zamudio.ramon.pokedexprueba.ui.theme.DarkGray
import zamudio.ramon.pokedexprueba.ui.theme.OffWhite
import zamudio.ramon.pokedexprueba.utilities.ColorPokemon

class Pokedex : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            pokemonInfo(pokemonList.get(2),pokemonList.get(3),pokemonList.get(1), PaddingValues(10.dp,15.dp))
        }
    }
}

@Composable
fun pokemonInfo(pokemon: Pokemon,pokesiguiente:Pokemon,pokeAnterior: Pokemon ,innerPadding: PaddingValues) {
    val pokemonColor1 = ColorPokemon(pokemon.type).first
    val pokemonColor2 = ColorPokemon(pokemon.type).second
    Column(Modifier.background(pokemonColor1).fillMaxSize().padding(16.dp)) {
        Spacer(modifier = Modifier.height(32.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top) {
            nameYNunmber(pokemon.name,pokemon.number.toString(),pokemonColor2)
            Image(painter = painterResource(R.drawable.estrella), contentDescription = "fav",
                Modifier.size(40.dp))
        }
        pokeImg(pokemon.image)
        Box(Modifier.fillMaxWidth().weight(1f).clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color.White).padding(24.dp)) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.clip(CircleShape).background(pokemonColor1).padding(horizontal = 16.dp, vertical = 6.dp)) {
                    tipoPoke(pokemon.type,pokemonColor2)
                }
                Spacer(modifier = Modifier.height(25.dp))
                pokeStats(pokemon.height.toString(),pokemon.weight.toString(),pokemon.ability,pokemon.descripcion)
                Spacer(modifier = Modifier.height(25.dp))
                siguentesPokes(pokeAnterior,pokesiguiente)
            }
        }
    }

}

@Composable
fun nameYNunmber(name:String, number:String,colorFondo: Color){
    Column(Modifier.width(IntrinsicSize.Max), horizontalAlignment = Alignment.End) {
        if(colorFondo == OffWhite){
            Text(name, fontSize = 32.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = OffWhite)
            Text("#"+number, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = OffWhite)
        }else{
            Text(name, fontSize = 32.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = DarkGray)
            Text("#"+number, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkGray)
        }

    }
}

@Composable
fun pokeImg(imagen:Int){
    Box(Modifier.fillMaxWidth()){
        Image(painter = painterResource(R.drawable.pokeball), contentDescription = "pokeball",
            Modifier.size(150.dp).align(BiasAlignment(horizontalBias = 1f, verticalBias = 0f)))
        Image(painter = painterResource(imagen), contentDescription = "pikachu",
            Modifier.size(160.dp).align(BiasAlignment(horizontalBias = -0.33f, verticalBias = 0f)))

    }
}

@Composable
fun tipoPoke(tipo:String,colorFondo:Color){
    if(colorFondo == OffWhite){
        Text(tipo, color = OffWhite, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }else{
        Text(tipo, color = DarkGray, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }

}

@Composable
fun pokeStats(altura: String, peso:String, habilidad: String,descripcion:String){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column(horizontalAlignment = Alignment.End){
            Text("Altura:", color = Color.Red, fontSize = 22.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
            Text("Peso:",color = Color.Red,fontSize = 22.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
        }
        Column{
            Text(altura.toString()+"m",fontSize = 22.sp, fontFamily = FontFamily.SansSerif)
            Text(peso.toString()+"Kg",fontSize = 22.sp, fontFamily = FontFamily.SansSerif)
        }
        Column{
            Text("habilidad:",color = Color.Red,fontSize = 22.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
            Text(habilidad,fontSize = 22.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
        }
    }
    Spacer(modifier = Modifier.height(45.dp))
    Row{
        Text(descripcion, fontSize = 20.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun siguentesPokes(pokeAnterior: Pokemon, pokeSig: Pokemon){
    Row(Modifier.fillMaxHeight().fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,Alignment.Bottom){
        Column{
            Image(painter = painterResource(pokeAnterior.image), contentDescription = pokeAnterior.name,
                Modifier.size(115.dp))
            Text(pokeAnterior.name+" #${pokeAnterior.number}", Modifier.align(Alignment.CenterHorizontally))
            Image(painter = painterResource(R.drawable.fecha_izq), contentDescription = "flecha_izq",
                Modifier.size(45.dp).align(alignment = Alignment.Start))
        }
        Column{
            Image(painter = painterResource(pokeSig.image), contentDescription = pokeSig.name,
                Modifier.size(115.dp))
            Text(pokeSig.name+" #${pokeSig.number}", Modifier.align(Alignment.CenterHorizontally))
            Image(painter = painterResource(R.drawable.flecha_der), contentDescription = "flecha_der",
                Modifier.size(45.dp).align(alignment = Alignment.End))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PorfileInfoPreview(){
    pokemonInfo(bulbasaur,pokemonList.get(3),pokemonList.get(1), PaddingValues(10.dp,15.dp))
}
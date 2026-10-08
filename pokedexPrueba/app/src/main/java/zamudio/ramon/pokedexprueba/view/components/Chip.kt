package zamudio.ramon.pokedexprueba.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zamudio.ramon.pokedexprueba.ui.theme.Normal
import zamudio.ramon.pokedexprueba.ui.theme.OffWhite

@Composable
fun NumberChip(texto:String, pair: Pair<Color,Color>, modifier : Modifier = Modifier){
    Row(modifier = modifier.width(35.dp).height(35.dp).background(pair.first, CircleShape).padding(5.dp),
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Text(texto, fontSize = 12.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Black, color = pair.second)
    }
}

@Preview(showBackground = true)
@Composable
fun previewNumberChip(){
    NumberChip("1", (Normal to OffWhite) )
}
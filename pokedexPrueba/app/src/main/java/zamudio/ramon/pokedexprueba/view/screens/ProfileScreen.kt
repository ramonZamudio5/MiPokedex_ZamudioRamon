package zamudio.ramon.pokedexprueba.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import zamudio.ramon.pokedexprueba.ui.theme.Pink40
import zamudio.ramon.pokedexprueba.ui.theme.Typography
import zamudio.ramon.pokedexprueba.viewModel.UserViewModel

@Composable
fun ProfileSceen(innerPadding : PaddingValues,
                 //userViewModel: UserViewModel = viewModel()
){
    val nombre = "ramon"
    /*
    if (userViewModel.currentUser != null){
            "${userViewModel.currentUser!!.name}"
        } else{
            "nombre usuario"
        }
     */
    val mail = "djhfkjsafhsk"
    /*
    if(userViewModel.currentUser != null) "${userViewModel.currentUser!!.email}" else "email"
     */
    Column(Modifier.fillMaxSize().padding(innerPadding)) {
        Text(nombre, style = Typography.displayLarge,color = Pink40)
        Text(mail,
            style = Typography.labelLarge,color = Pink40)
        Spacer(Modifier.size(50.dp))
        Text("Mi compañero,", style = Typography.titleLarge,color = Pink40)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen(){
    ProfileSceen(PaddingValues(10.dp))
}
package zamudio.ramon.pokedexprueba.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import zamudio.ramon.pokedexprueba.viewModel.UserViewModel

@Composable
fun LoginScreen(innerPadding: PaddingValues, viewModel: UserViewModel = viewModel(),onNavigateToMenu : ()->Unit){
    var user by remember{ mutableStateOf("") }
    var password = remember{ TextFieldState() }
    if(viewModel.isLoggesIn()){
        onNavigateToMenu()
    }
    else{
        Column(Modifier.fillMaxWidth().padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            TextField(
                value = user,
                onValueChange = { it -> user = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = {
                    Text("Correo elecctronico")
                })
            SecureTextField(state = password,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = {
                    Text("Contraseña")
                },textObfuscationMode = TextObfuscationMode.RevealLastTyped)

            Button(onClick = {
                viewModel.login(user, password.text as String)
            }) {
                Text("Iniciar sesión")
            }
            if (viewModel.loginError) {
                Text(viewModel.errorDescription, color = Color.Red, fontStyle = FontStyle.Italic)
            }
        }
    }
}


@Preview
@Composable
fun previewLogin(){
    LoginScreen(PaddingValues(10.dp), onNavigateToMenu = {})
}



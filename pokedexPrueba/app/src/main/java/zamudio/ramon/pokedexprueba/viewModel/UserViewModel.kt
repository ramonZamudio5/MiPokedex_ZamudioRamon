package zamudio.ramon.pokedexprueba.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import zamudio.ramon.pokedexprueba.model.data.Users
import zamudio.ramon.pokedexprueba.model.domain.User


class UserViewModel(users: Users) {
    var currentUser by mutableStateOf<User?>(null)

    init {

        currentUser = users.getCurrentUser()
    }

    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")
    val users = users

    fun login(ussr: String, password: String){
        val user = users.loginService(ussr,password)
        if(user == null){
            loginError = true
            errorDescription = "usuario o contraseña incorrectos"
        }
        else{
            loginError = false
            errorDescription = ""
            users.saveUser(user.email,user.name)

        }
    }

    fun isLoggesIn():Boolean{
        return users.isLoggedIn()
    }

    fun logOut(){
        users.logOut()
        currentUser = null
    }


}
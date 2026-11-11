package zamudio.ramon.pokedexprueba.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import zamudio.ramon.pokedexprueba.model.data.CompanionPreferences
import zamudio.ramon.pokedexprueba.model.data.Users
import zamudio.ramon.pokedexprueba.model.domain.Pokemon
import zamudio.ramon.pokedexprueba.model.domain.User
import zamudio.ramon.pokedexprueba.model.references.PokemonSerializer


class UserViewModel(users: Users,private val companionDataStore: CompanionPreferences): ViewModel() {
    var currentUser by mutableStateOf<User?>(null)

    init {
        currentUser = users.getCurrentUser()
    }

    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")
    val users = users

    val companion: StateFlow<Pokemon> = companionDataStore.pokemonCompanion().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PokemonSerializer.defaultValue)

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
package zamudio.ramon.pokedexprueba.model.data

import android.content.Context
import zamudio.ramon.pokedexprueba.model.references.ARCHIVO
import zamudio.ramon.pokedexprueba.model.references.USER
import zamudio.ramon.pokedexprueba.model.references.USERNAME
import zamudio.ramon.pokedexprueba.model.domain.User
import kotlin.text.equals


class Users(con: Context){

    val shared = con.getSharedPreferences(ARCHIVO,Context.MODE_PRIVATE)

    fun saveUser(user:String,name:String){
        val editor = shared.edit()
        editor.putString(USER,user)
        editor.putString(USERNAME,name)
        editor.apply()
    }


    fun isLoggedIn():Boolean{
        val user = shared.getString(USER,null)
        val username = shared.getString(USERNAME,null)
        if(user != null && username != null){
            return true
        }
        return false
    }

    fun logOut(){
        val editor = shared.edit()
        editor.putString(USER,null)
        editor.putString(USERNAME,null)
        editor.apply()
    }

    val validUsers = listOf<User>(
        User("alma@mail.com","12345678","Alma Chavez"),
        User("ramon@gmail.com","098765","Ramón Zamudio"),
        User("alex@mail.com","7483929","Alex Ayala")
    )

    fun getUserByMail(mail: String): User?{
        val users = validUsers.filter { it.email.equals(mail, ignoreCase = true) }
        return if(users.isEmpty()) null else users.first()
    }

    fun loginService(user: String,password:String): User?{
        val user = getUserByMail(user)
        user?.let{
            if(user.password.equals(password)){
                return user
            }
        }
        return null
    }

    fun getCurrentUser(): User?{
        val user = shared.getString(USER,null)
        if(user != null){
            return getUserByMail(user)
        }
        return null
    }
}

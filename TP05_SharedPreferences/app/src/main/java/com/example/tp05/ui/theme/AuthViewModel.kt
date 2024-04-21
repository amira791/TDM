import androidx.lifecycle.ViewModel
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

class AuthViewModel(private val sharedPreferencesManager: SharedPreferencesManager) : ViewModel() {

    private val users = mapOf(
        "amira" to "123",
        "user2" to "password2"
    )

    fun authenticate(username: String, password: String): Boolean {
        val storedPassword = users[username]
        return storedPassword == password
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferencesManager.isLoggedIn()
    }

    fun setLoggedIn(value: Boolean) {
        sharedPreferencesManager.setLoggedIn(value)
    }
}




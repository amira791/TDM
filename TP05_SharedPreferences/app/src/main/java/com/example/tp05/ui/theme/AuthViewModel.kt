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
        // Check if the provided username exists
        val storedPassword = users[username]
        if (storedPassword != null) {
            // Compare the provided password with the stored password
            return password == storedPassword
        }
        return false
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferencesManager.isLoggedIn()
    }

    fun setLoggedIn(value: Boolean) {
        sharedPreferencesManager.setLoggedIn(value)
    }
}





class SharedPreferencesManager {

    private val pref: SharedPreferences

    constructor(context: Context) {
        pref = context.applicationContext.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setLoggedIn(value: Boolean) {
        pref.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()
    }

    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
    }
}

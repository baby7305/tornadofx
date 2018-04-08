

import model.Usertest
import tornadofx.*

class LoginController : Controller() {
    val loginScreen: LoginScreen by inject()
    val secureScreen: SecureScreen by inject()

    val api: Rest by inject()
    //    val api = Rest()
    fun loadUsertests() = api.get("/usertests").list().toModel<Usertest>()

    val mapTableContent1=getUsertest(1)

    fun init() {
        with(config) {
            if (containsKey(USERNAME) && containsKey(PASSWORD))
                tryLogin(string(USERNAME), string(PASSWORD), true)
            else
                showLoginScreen("Please log in")
        }
    }

    fun showLoginScreen(message: String, shake: Boolean = false) {
        secureScreen.replaceWith(loginScreen, sizeToScene = true, centerOnScreen = true)
        runLater {
            if (shake) loginScreen.shakeStage()
        }
    }

    fun showSecureScreen() {
        loginScreen.replaceWith(secureScreen, sizeToScene = true, centerOnScreen = true)
    }

    fun tryLogin(username: String, password: String, remember: Boolean) {
        runAsync {
//            username == "admin" && password == "secret"
            username == mapTableContent1.loginname && password == mapTableContent1.password
        } ui { successfulLogin ->

            if (successfulLogin) {
                loginScreen.clear()

                if (remember) {
                    with(config) {
                        set(USERNAME to username)
                        set(PASSWORD to password)
                        save()
                    }
                }

                showSecureScreen()
            } else {
                showLoginScreen("Login failed. Please try again.", true)
            }
        }
    }

    fun logout() {
        with(config) {
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }

        showLoginScreen("Log in as another user")
    }

    companion object {
        val USERNAME = "username"
        val PASSWORD = "password"
    }

    fun getUsertest(id: Int): Usertest {
        val response = api.get("/usertests/${id}")

        try {
            if (response.ok()) {
                val result = response.one().toModel<Usertest>()
                return result
            } else {
                throw Exception("getUsertest required ${response.statusCode} ${response.reason}")
            }

        } finally {
            response.consume()
        }
    }

    fun findUsertest(): List<Usertest> {
        val response = api.get("/usertests")
        val result = response.list().toModel<Usertest>()
        return result
    }

}
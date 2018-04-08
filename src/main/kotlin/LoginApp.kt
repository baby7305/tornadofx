

import javafx.stage.Stage
//import no.tornado.fxsample.login.LoginController
//import no.tornado.fxsample.login.LoginScreen
//import no.tornado.fxsample.login.Styles
import tornadofx.*

class LoginApp : App(LoginScreen::class, Styles::class) {
    val loginController: LoginController by inject()

    override fun start(stage: Stage) {
        super.start(stage)
        loginController.init()
    }

    val api: Rest by inject()
//    val api = Rest()

    init {
//        Rest.useApacheHttpClient()
//        api.
        api.baseURI = "http://192.168.88.91:8080/api"
    }
}

fun main(args: Array<String>) {
    launch<LoginApp>(args)
}
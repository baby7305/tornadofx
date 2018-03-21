

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
}

fun main(args: Array<String>) {
    launch<LoginApp>(args)
}
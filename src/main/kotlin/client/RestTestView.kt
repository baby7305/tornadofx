package client

import tornadofx.*

class RestTestView : View("My View") {

    val controller : RestTestController by inject()

    override val root = vbox {
        button("Load JSON" ) {
            setOnAction {
                controller.load()
            }
        }
    }
}
package usertest

import tornadofx.*

class UsertestView:View("My View") {
    val controller:UsertestController by inject()
    override val root = vbox {
        button("Load JSON" ) {
            setOnAction {
                controller.load()
            }
        }
    }
}
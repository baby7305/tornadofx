package usertest

import javafx.collections.FXCollections
import tornadofx.*

class UsertestView:View("My View") {
    val api : Rest by inject()
    val controller:UsertestController by inject()
//    val mapTableContent = mapOf<>()
    val mapTableContent1=controller.getUsertest(1)
    override val root = vbox {
        button("Load JSON" ) {
            setOnAction {
                controller.load()
            }
        }
        button("Get Model"){
            setOnAction {
//                label("Tableview from a map")
//                label("test:${mapTableContent1.loginname}")
                label("test:${mapTableContent1.password}")
            }
        }
    }
}
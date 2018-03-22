package usertest

import tornadofx.*

class UsertestController:Controller() {
    val api : Rest by inject()
//    val api = Rest()

    fun load() {
        val response = api.get("/usertests")
        println("status=${response.status}")
        println("content=${response.text()}")

    }
}
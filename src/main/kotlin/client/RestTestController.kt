package client

import tornadofx.*

class RestTestController : Controller() {

    val api : Rest by inject()
//    val api = Rest()

    fun load() {
        val response = api.get("/customers.json")
        println("status=${response.status}")
        println("content=${response.text()}")

    }
}
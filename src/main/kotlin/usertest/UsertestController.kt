package usertest

import javafx.collections.ObservableList
import model.Usertest
import model.Usertest1
import model.UsertestModel
import tornadofx.*

class UsertestController : Controller() {
    val api: Rest by inject()
    //    val api = Rest()
    fun loadUsertests() = api.get("/usertests").list().toModel<Usertest>()

    fun load() {
        val response = api.get("/usertests")
//        val list = new
        println("status=${response.status}")
        println("content=${response.text()}")
//        println("${response}")

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
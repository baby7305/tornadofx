package model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class Usertest : JsonModel {
    val idProperty = SimpleLongProperty()
    var id by idProperty

    val nameProperty = SimpleStringProperty()
    var name by nameProperty

    val sexProperty = SimpleStringProperty()
    var sex by sexProperty

    val ageProperty = SimpleIntegerProperty()
    var age by ageProperty

    val loginnameProperty = SimpleStringProperty()
    var loginname by loginnameProperty

    val passwordProperty = SimpleStringProperty()
    var password by passwordProperty

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = long("id") ?: 0
            name = string("name")
            sex = string("sex")
            age = int("age") ?: 0
            loginname = string("loginname")
            password = string("password")

//            id = long("id")
//            name = string("name")
//            sex = string("sex")
//            age = int("age")
//            loginname = string("loginname")
//            password = string("password")
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("id", id)
            add("name", name)
            add("sex", sex)
            add("age", age)
            add("loginname", loginname)
            add("password", password)
        }
    }
}
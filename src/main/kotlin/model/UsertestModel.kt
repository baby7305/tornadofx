package model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*


data class Usertest1(val id: Long, val name: String, val sex: String, val age: Int, val loginname: String, val password: String)

class UsertestModel() : ItemViewModel<Usertest>() {
    val id = bind { SimpleLongProperty(item?.id ?: 0) }
    val name = bind { SimpleStringProperty(item?.name ?: "") }
    val sex = bind { SimpleStringProperty(item?.sex ?: "") }
    val age = bind { SimpleIntegerProperty(item?.age ?: 0) }
    val loginname = bind { SimpleStringProperty(item?.loginname ?: "") }
    val password = bind { SimpleStringProperty(item?.password ?: "") }
}

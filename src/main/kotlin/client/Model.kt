package client

import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import tornadofx.*
import java.time.LocalDate

data class Customer(val id: Long, val firstname: String, val lastname: String)

class CustomerModel() : ItemViewModel<Customer>() {
    val id = bind { SimpleLongProperty(item?.id ?: 0) }
    val firstname = bind { SimpleStringProperty(item?.firstname ?: "") }
    val lastname = bind { SimpleStringProperty(item?.lastname ?: "") }
}
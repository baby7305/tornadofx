package usertest

import tornadofx.*

class UsertestAPP : App(UsertestView::class) {
    val api: Rest by inject()
//    val api = Rest()

    init {
//        Rest.useApacheHttpClient()
//        api.
        api.baseURI = "http://192.168.88.91:8080/api"
    }
}

fun main(args:Array<String>){
    launch<UsertestAPP>(args)
}
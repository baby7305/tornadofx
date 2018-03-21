package client

import tornadofx.*





class RestTestApp : App(RestTestView::class) {

    val api : Rest by inject()
//    val api = Rest()

    init {
//        Rest.useApacheHttpClient()
//        api.
        api.baseURI = "https://www.bekwam.net/data"    }
}

fun main(args:Array<String>){
    launch<RestTestApp>(args)
}
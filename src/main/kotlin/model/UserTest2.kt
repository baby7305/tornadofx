package model

import tornadofx.*

class UserTest2(id:Long,name:String,sex:String,age:Int,loginname:String,password:String) {
    var id by property(id)
    fun idProperty()=getProperty(UserTest2::id)

    var name by property(name)
    fun nameProperty()=getProperty(UserTest2::name)

    var sex by property(sex)
    fun sexProperty()=getProperty(UserTest2::sex)

    var age by property(age)
    fun ageProperty()=getProperty(UserTest2::age)

    var loginname by property(loginname)
    fun loginnameProperty()=getProperty(UserTest2::loginname)

    var password by property(password)
    fun passwordProperty()=getProperty(UserTest2::password)
}
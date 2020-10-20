package com.tool.jizhang.data
import java.io.Serializable

open class BaseBean :Serializable {
    var data: String = "" //先对data进行解密

    var code: Int = 0

    var message: String? = null
}
class SysInitResp : BaseBean() {
    var result: SysInitBean? = null
}
class SysInitBean {

}
class LoginResp : BaseBean() {

}
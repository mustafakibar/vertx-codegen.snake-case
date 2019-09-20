package model

import io.vertx.codegen.annotations.DataObject
import io.vertx.core.json.JsonObject

@DataObject(generateConverter = true)
class Response() {
    var statusId: Int = -1

    constructor(json: JsonObject) : this() {
        ResponseConverter.fromJson(json, this)
    }

    fun toJson() = JsonObject().also { ResponseConverter.toJson(this, it) }
}

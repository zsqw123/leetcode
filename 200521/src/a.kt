/**
 * This file just create for test.
 */

class User(val map: Map<String, Any?>) {
    val name: String by map
}

fun main() {
    val user = User(mapOf("name" to "zzz"))
    println(user.name)
}
import kotlin.reflect.KClass

/**
 * This file just create for test.
 */
val map = hashMapOf<String, Any>()
inline fun <reified T> getTReifiedNull(): T? {
    return map[""] as? T
}

fun <T> getTNull(): T? {
    return map[""] as? T
}

fun main() {
    val r = getTReifiedNull<Int>()
    println(r)
    val a = getTNull<Int>()
    println(a)
}
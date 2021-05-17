import utils.prl
import java.io.File
import java.nio.file.Path

/**
 * This file just create for test.
 */
infix fun String.and(str: String): String {
    val a = map { it.toInt() }
    val b = str.hashCode()
    return String(a.map { it.and(b).toChar() }.toCharArray())
}

fun main() {
    println("peace" and "love")
}
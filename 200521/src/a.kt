import utils.prl
import java.io.File

/**
 * This file just create for test.
 */

inline operator fun <reified T> String.minus(value: T): String {
    val v = when (value) {
        is Number -> value.toString()
        else -> "\"$value\""
    }
    return "\"$this\" : $v"
}

fun main() {
    println("awa" - 1)
    println("awa" - "hhhhc")
    val root = File("C:/a")
    val a = File(root, "awa/b/")
    val b = File(root, "/awa/b/")
    val c = File(root, "awa/b")
    val d = File(root, "/awa/b")
    a.absolutePath.prl()
    b.absolutePath.prl()
    c.absolutePath.prl()
    d.absolutePath.prl()
    ((a == b) && (b == c) && (c == d)).prl()
}
import utils.prl
import java.io.File

/**
 * This file just create for test.
 */

fun main() {
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
import utils.prl

/**
 * This file just create for test.
 */

fun main() {
    val regex=Regex("""\{.*?}""")
    regex.find("dawwaw{awa}adwaaw")?.value.prl()
}

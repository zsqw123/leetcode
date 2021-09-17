import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * This file just create for test.
 */
fun awa(method: (Int) -> Unit) {
    method(1)
}

suspend fun main() {
    val suspendCoroutine = suspendCoroutine<Int> { con ->
        awa {
            con.resume(it)
        }
    }
    println(suspendCoroutine)
}

object AWA {
    fun hi(): (Int) -> Unit {
        return {}
    }
}
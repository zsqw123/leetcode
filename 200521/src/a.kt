import utils.prl
import java.io.File
import java.nio.file.Path
import kotlin.math.roundToInt
import kotlin.random.Random

/**
 * This file just create for test.
 */
fun main() {
    val ran = Random(System.currentTimeMillis())
    repeat(10) {
        print((ran.nextFloat() * 5).toString() + "Ω ")
        val v = ran.nextFloat() * 5
        repeat(4) {
            print((v + ran.nextFloat() * 0.4f).toString() + "V ")
        }
        println()
    }
}
import kotlin.reflect.KClass

/**
 * This file just create for test.
 */
val <A> List<A>.length
    get() = size

val <A> List<A>.anyone
    get() = random()

// 万能 List
val nothingList get() = listOf<Nothing>()

val strList: List<String> = nothingList
val intList: List<Int> = nothingList

val <T> T.singleItemList: ArrayList<T> get() = arrayListOf(this)
val <T> T.isStr: Boolean get() = this is String

// 得到集合的泛型类型
inline val <reified T : Any> Collection<T>.itemKClass: KClass<T> get() = T::class

val <T> T.printThen: T get() = also(::println)
fun genList(): List<Number> = listOf(1)
fun main() {
    genList().itemKClass.printThen
    genList()[0]::class.printThen
    listOf(1).itemKClass.printThen
    1.isStr.printThen
    2.singleItemList.printThen
    "hello".uppercase().length
    "hello".printThen.uppercase().printThen.length.printThen
}
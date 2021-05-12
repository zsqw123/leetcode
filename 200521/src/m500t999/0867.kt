package m500t999

fun main() {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> =
        Array(matrix[0].size) { IntArray(matrix.size) }.apply { matrix.forEachIndexed { j, v -> v.forEachIndexed { i, vv -> get(i)[j] = vv } } }
}
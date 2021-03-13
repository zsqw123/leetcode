fun main() {
    class MyHashSet() {
        private val array = BooleanArray(1_000_000)
        fun add(key: Int) {
            array[key] = true
        }

        fun remove(key: Int) {
            array[key] = false
        }

        fun contains(key: Int): Boolean = array[key]
    }

    class MyHashSet2() {
        private val array = IntArray(31251)
        fun add(key: Int) {
            array[key / 32] = array[key / 32] or (1 shl key % 32)
        }

        fun remove(key: Int) {
            array[key / 32] = array[key / 32] and (1 shl key % 32).inv()
        }

        fun contains(key: Int): Boolean = array[key / 32] and (1 shl (key % 32)) != 0
    }
}

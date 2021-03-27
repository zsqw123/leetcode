fun main() {
    fun isPalindrome(s: String): Boolean {
        val c = s.toLowerCase()
        var i = 0
        var j = s.length - 1
        while (i < j) {
            if (!(c[i] in '0'..'9' || c[i] in 'a'..'z')) {
                i++
                continue
            }
            if (!(c[j] in '0'..'9' || c[j] in 'a'..'z')) {
                j--
                continue
            }
            if (c[i] != c[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }
}
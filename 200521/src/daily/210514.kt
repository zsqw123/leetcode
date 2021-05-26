package daily

fun dfs(str: CharArray, start: Int) {
    if (start == str.size - 1) println(String(str))
    else for (i in start until str.size) {
        var tmp = str[i]
        str[i] = str[start]
        str[start] = tmp
        dfs(str, start + 1)
        tmp = str[i]
        str[i] = str[start]
        str[start] = tmp
    }
}

fun main() {
    val str = "abcd"
    dfs(str.toCharArray(), 0)
}
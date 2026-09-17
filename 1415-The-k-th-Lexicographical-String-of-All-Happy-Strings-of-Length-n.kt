class Solution {
    fun getHappyString(n: Int, k: Int): String {
        val items = mutableListOf<String>()
        generate(StringBuilder(), items, n)
        return items.getOrNull(k - 1) ?: ""
    }

    fun generate(sb: StringBuilder, items: MutableList<String>, n: Int) {
        if (sb.length == n) {
            items.add(sb.toString())
            return
        }

        val current = sb.lastOrNull()
        if (current != 'a') {
            generate(sb.append('a'), items, n)
            sb.deleteAt(sb.length - 1)
        }
        if (current != 'b') {
            generate(sb.append('b'), items, n)
            sb.deleteAt(sb.length - 1)
        }
        if (current != 'c') {
            generate(sb.append('c'), items, n)
            sb.deleteAt(sb.length - 1)
        }
    }
}

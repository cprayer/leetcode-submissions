class Solution {
    fun reverseParentheses(s: String): String {
        val deque = ArrayDeque<Char>()
        for (ch in s) {
            when (ch) {
                '(' -> deque.add(ch)
                ')' -> {
                    val stringBuilder = StringBuilder()
                    while (deque.last() != '(') {
                        stringBuilder.append(deque.removeLast())
                    }
                    // '(' 제거
                    deque.removeLast()
                    deque.addAll(stringBuilder.toList())
                }
                else -> deque.add(ch)
            }
        }
        return deque.joinToString("")
    }
}

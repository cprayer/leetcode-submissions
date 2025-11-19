class Solution {
    fun reverseParentheses(s: String): String {
        val deque = ArrayDeque<Int>()
        val indexes = mutableMapOf<Int, Int>()

        for ((index, ch) in s.withIndex()) {
            when (ch) {
                '(' -> deque.add(index)
                ')' -> {
                    val left = deque.removeLast()
                    val right = index
                    indexes[left] = right
                    indexes[right] = left
                }
            }
        }

        fun getAnswer(s: String, stringBuilder: StringBuilder, start: Int, end: Int, reversed: Boolean) {
            if (reversed) {
                var current = end
                while (current >= start) {
                    when (s[current]) {
                        ')' -> {
                            getAnswer(s, stringBuilder, indexes.getValue(current) + 1, current - 1, false)
                            current = indexes.getValue(current) - 1
                        }
                        else -> {
                            stringBuilder.append(s[current])
                            current -= 1
                        }
                    }
                }
            } else {
                var current = start
                while (current <= end) {
                    when (s[current]) {
                        '(' -> {
                            getAnswer(s, stringBuilder, current + 1, indexes.getValue(current) - 1, true)
                            current = indexes.getValue(current) + 1
                        }
                        else -> {
                            stringBuilder.append(s[current])
                            current += 1
                        }
                    }
                }
            }
        }

        val stringBuilder = StringBuilder()
        getAnswer(s, stringBuilder, 0, s.length - 1, false)
        return stringBuilder.toString()
    }
}

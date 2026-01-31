class Solution {
    fun scoreOfParentheses(s: String): Int {
        val deque = ArrayDeque<Int>()
        val mappings = mutableMapOf<Int, Int>()
        for ((index, ch) in s.withIndex()) {
            when (ch) {
                '(' -> deque.add(index)
                else -> // ')'
                {
                    val at = deque.removeLast()
                    mappings[at] = index
                }
            }
        }

        fun getAnswer(start: Int, end: Int): Int {
            if (start + 1 == end) {
                return 1
            }


            var currentLeft = start + 1
            var sum = 0
            while (currentLeft < end) {
                val currentRight = mappings.getValue(currentLeft)
                sum += getAnswer(currentLeft, currentRight)
                currentLeft = currentRight + 1
            }

            return sum * 2
        }

        var currentLeft = 0
        var answer = 0
        while(currentLeft < s.length) {
            val currentRight = mappings.getValue(currentLeft)
            answer += getAnswer(currentLeft, currentRight)
            currentLeft = currentRight + 1
        }

        return answer
    }
}

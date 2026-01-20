import java.lang.Integer.min

class Solution {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        val deque = ArrayDeque<Char>()
        var answer = 0
        for (ch in s + 'z') {
            if (ch != 'a' && ch != 'b') {
                val a = deque.count { it == 'a' }
                val b = deque.count { it == 'b' }

                answer += min(a, b) * min(x, y)
                deque.clear()
            } else {
                if (x > y) {
                    if (deque.isNotEmpty() && deque.last() == 'a' && ch == 'b') {
                        answer += x
                        deque.removeLast()
                    } else {
                        deque.add(ch)
                    }
                } else {
                    if (deque.isNotEmpty() && deque.last() == 'b' && ch == 'a') {
                        answer += y
                        deque.removeLast()
                    } else {
                        deque.add(ch)
                    }
                }
            }
        }
        return answer
    }
}

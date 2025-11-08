import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        val queue = ArrayDeque(arr.toList())
        val v = min(k, arr.size)

        var winCount = 0
        while(true) {
            val a = queue.removeFirst()
            val b = queue.removeFirst()
            queue.addFirst(max(a, b))
            queue.addLast(min(a, b))

            if (a > b) {
                winCount += 1
            } else {
                winCount = 1
            }

            if (winCount == v) {
                return max(a, b)
            }
        }
    }
}

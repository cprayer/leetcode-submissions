
class Solution {
    fun minimumOperationsToMakeEqual(x: Int, y: Int): Int {
        val maxLength = 100_009
        val deque = ArrayDeque<Int>()
        val dp = IntArray(maxLength) { -1 }

        deque.add(x)
        var distance = 0
        while(true) {
            val size = deque.size
            for (i in 0 until size) {
                val current = deque.removeFirst()
                if (dp[current] != -1) {
                    continue
                }
                if (current == y) {
                    return distance
                }

                if (current + 1 < maxLength && dp[current + 1] == -1 ) {
                    deque.add(current + 1)
                }
                if (current - 1 > 0 && dp[current - 1] == -1) {
                    deque.add(current - 1)
                }
                if (current % 5 == 0 && dp[current / 5] == -1) {
                    deque.add(current / 5)
                }
                if (current % 11 == 0 && dp[current / 11] == -1) {
                    deque.add(current / 11)
                }

                dp[current] = distance
            }
            distance += 1
        }
    }
}

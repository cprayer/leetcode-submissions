import java.lang.Long.max

class Solution {
    fun maximumSumOfHeights(maxHeights: List<Int>): Long {
        val lefts = generate(maxHeights)
        val rights = generate(maxHeights.reversed()).reversedArray()

        var answer = 0L
        for (index in maxHeights.indices) {
            val left = lefts.getOrNull(index) ?: 0L
            val right = rights.getOrNull(index + 1) ?: 0L
            answer = max(answer, left + right)
        }

        return answer
    }

    private fun generate(maxHeights: List<Int>): LongArray {
        val items = LongArray(maxHeights.size)
        val deque = ArrayDeque<Pair<Long, Long>>()
        var sum = 0L

        for ((index, maxHeight) in maxHeights.withIndex()) {
            var removeCount = 0L
            while (deque.isNotEmpty()) {
                val (current, count) = deque.last()
                if (current < maxHeight) {
                    break
                }
                sum -= (current - maxHeight) * count
                removeCount += count
                deque.removeLast()
            }
            deque.add(maxHeight.toLong() to (removeCount + 1))
            sum += maxHeight
            items[index] = sum
        }

        return items
    }
}

import java.lang.Integer.max

class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums.first()
        }

        val mins = PriorityQueue<IndexedValue> { o1, o2 ->
            if (o1.value != o2.value) {
                o1.value - o2.value
            } else {
                o1.index - o2.index
            }
        }

        var answer = Int.MIN_VALUE
        var sum = 0
        for ((currentIndex, num) in (nums + nums).withIndex()) {
            sum += num
            if (currentIndex < nums.size) {
                answer = max(answer, sum)
            }

            while (mins.isNotEmpty()) {
                val (value, index) = mins.peek()
                if (currentIndex - index >= nums.size) {
                    mins.poll()
                } else {
                    answer = max(answer, sum - value)
                    break
                }
            }

            val element = IndexedValue(value = sum, index = currentIndex)
            mins.add(element)
        }

        return answer
    }

    data class IndexedValue(
        val value: Int,
        val index: Int,
    )
}

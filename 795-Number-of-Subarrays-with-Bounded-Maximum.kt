class Solution {
    fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
        var answer = 0L
        val queue = ArrayDeque<Int>()
        for (num in (nums + Int.MAX_VALUE)) {
            if (num > right) {
                answer += (1L * queue.size * (queue.size + 1) / 2)
                var count = 0
                while (queue.isNotEmpty()) {
                    val v = queue.removeFirst()
                    if (v < left) {
                        count += 1
                    } else {
                        answer -= (1L * count * (count + 1) / 2)
                        count = 0
                    }
                }
                answer -= (1L * count * (count + 1) / 2)
            } else {
                queue.add(num)
            }
        }

        return answer.toInt()
    }
}

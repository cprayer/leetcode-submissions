import java.util.*

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val priorityQueue = PriorityQueue(Comparator<Pair<Int, Int>> { o1, o2 ->
            if (o1.first != o2.first) {
                o1.first - o2.first
            } else {
                o1.second - o2.second
            }
        })

        for (i in 0 until nums.size - k) {
            priorityQueue.add(nums[i] to i)
        }
        var lastIndex = -1
        val answer = mutableListOf<Int>()
        for (i in nums.size - k until nums.size) {
            priorityQueue.add(nums[i] to i)
            while(priorityQueue.isNotEmpty()) {
                val (num, currentIndex) = priorityQueue.poll()
                if (lastIndex > currentIndex) {
                    continue
                }
                lastIndex = currentIndex
                answer.add(num)
                break
            }
        }

        return answer.toIntArray()
    }
}

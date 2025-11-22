import java.util.*

class Solution {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        val priorityQueue = PriorityQueue<Int> { l, r -> r - l }
        priorityQueue.add(a)
        priorityQueue.add(b)
        priorityQueue.add(c)

        var count = 0
        while (true) {
            val v1 = priorityQueue.poll()
            val v2 = priorityQueue.poll()
            val v3 = priorityQueue.poll()

            if (v2 == 0 && v2 == v3) {
                return count
            }
            count += 1

            priorityQueue.add(v1 - 1)
            priorityQueue.add(v2 - 1)
            priorityQueue.add(v3)
        }
    }
}

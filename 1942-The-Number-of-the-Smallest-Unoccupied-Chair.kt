import java.util.PriorityQueue

class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val friends = times.indices.sortedBy { times[it][0] }
        val occupied = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val available = PriorityQueue<Int>()
        var nextChair = 0

        for (friend in friends) {
            val (arrival, leaving) = times[friend]

            while (occupied.isNotEmpty() && occupied.peek().first <= arrival) {
                available.offer(occupied.poll().second)
            }

            val chair = if (available.isNotEmpty()) {
                available.poll()
            } else {
                nextChair++
            }

            if (friend == targetFriend) return chair

            occupied.offer(leaving to chair)
        }

        return -1
    }
}

class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val flatted = times.flatMapIndexed { index: Int, ints: IntArray -> listOf(Triple(ints[0], true, index), Triple(ints[1], false, index))  }
            .sortedWith(compareBy<Triple<Int, Boolean, Int>> { it.first }.thenBy { it.second }.thenBy { it.third })

        val seats = mutableMapOf<Int, Int>()
        val pq = PriorityQueue<Int>()
        for (i in times.indices) {
            pq.add(i)
        }
        for ((time, isArrived, index) in flatted) {
            if (isArrived) {
                val current = pq.poll()
                seats[index] = current
                if (targetFriend == index) {
                    return current
                }
            } else {
                pq.add(seats[index])
            }
        }
        return -1
    }
}

class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val counts = MutableList(numCourses) { 0 }
        val edges = List<MutableList<Int>>(numCourses) { mutableListOf() }

        for ((a, b) in prerequisites) {
            counts[a] += 1
            edges[b] += a
        }

        val answer = mutableListOf<Int>()
        val currentCourses = ArrayDeque(counts.mapIndexed { index, i -> index to i }
            .filter { (_, i) -> i == 0 }
            .map { (index, _) -> index }
        )

        while (currentCourses.isNotEmpty()) {
            val size = currentCourses.size
            repeat(size) {
                val course = currentCourses.removeFirst()
                answer += course
                for (to in edges[course]) {
                    counts[to] -= 1
                    if (counts[to] == 0) {
                        currentCourses += to
                    }
                }
            }
        }

        return if (answer.size == numCourses) {
            return answer.toIntArray()
        } else {
            return IntArray(0)
        }
    }
}

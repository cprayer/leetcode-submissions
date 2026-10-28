import java.lang.Integer.max

class Solution {
    fun maxNumberOfAlloys(n: Int, k: Int, budget: Int, composition: List<List<Int>>, stock: List<Int>, cost: List<Int>): Int {
        fun findMax(selected: Int): Int {
            var l = -1
            var r = 2_000_000_009

            while(l + 1 < r) {
                val m = (l + r) / 2
                var costSum = 0L
                for ((index, count) in composition[selected].withIndex()) {
                    val neededMetalCount = m.toLong() * count - stock[index]
                    if (neededMetalCount > 0) {
                        costSum += neededMetalCount * cost[index]
                    }
                }

                if (costSum <= budget) {
                    l = m
                } else {
                    r = m
                }
            }

            return l
        }

        var ans = 0
        for (i in 0 until k) {
            ans = max(ans, findMax(i))
        }

        return ans
    }
}

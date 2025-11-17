import java.lang.Integer.min
import java.util.*

class Solution {
    fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
        val indexesByNum = Array<TreeSet<Int>> (109) { TreeSet() }
        for (i in nums.indices) {
            val num = nums[i]
            indexesByNum[num].add(i)
        }

        val answer = mutableListOf<Int>()
        for((l, r) in queries) {
            var previous = -1
            var diff = Int.MAX_VALUE
            for(v in 1..100) {
                if ((indexesByNum[v].ceiling(l) ?: Int.MAX_VALUE) <= r) {
                    if (previous != -1) {
                        diff = min(diff, v - previous)
                    }
                    previous = v
                }
            }
            answer.add(
                if (diff == Int.MAX_VALUE) {
                    -1
                } else {
                    diff
                }
            )
        }
        return answer.toIntArray()
    }
}

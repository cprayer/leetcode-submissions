import java.lang.Integer.max

class Solution {
    fun longestEqualSubarray(nums: List<Int>, k: Int): Int {
        val positionsByNum = mutableMapOf<Int, MutableList<Int>>()
        for ((i, num) in nums.withIndex()) {
            positionsByNum.computeIfAbsent(num) { mutableListOf() }.add(i)
        }

        var answer = 0
        for((num, positions) in positionsByNum) {
            var rightIndex = 0
            for (leftIndex in positions.indices) {
                while(true) {
                    val deletedItems = positions[rightIndex] + 1 - positions[leftIndex] - (rightIndex + 1 - leftIndex)
                    val isIn = deletedItems <= k
                    if (isIn) {
                        answer = max(answer, rightIndex + 1 - leftIndex)
                    } else {
                        break
                    }
                    if (rightIndex < positions.size - 1) {
                        rightIndex += 1
                    } else {
                        break
                    }
                } 
            }
        }

        return answer
    }
}

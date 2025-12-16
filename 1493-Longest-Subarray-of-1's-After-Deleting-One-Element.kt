import java.lang.Integer.max

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val size = nums.size
        if (!nums.contains(0)) {
            return size - 1
        }
        if (!nums.contains(1)) {
            return 0
        }

        val counts = mutableListOf<Pair<Int, Int>>()
        var index = 0
        while (index < size) {
            if (nums[index] == 0) {
                var zeroCount = 0
                while(index < size && nums[index] == 0) {
                    zeroCount += 1
                    index += 1
                }
                counts.add(0 to zeroCount)
            } else {
                var oneCount = 0
                while(index < size && nums[index] == 1) {
                    oneCount += 1
                    index += 1
                }
                counts.add(1 to oneCount)
            }
        }

        var answer = 0
        for (i in 1 until counts.size - 1) {
            val (v, count) = counts[i]
            if (v == 0 && count == 1) {
                val (leftV, leftCount) = counts[i - 1]
                val (rightV, rightCount) = counts[i + 1]

                if (leftV == 1 && rightV == 1) {
                    answer = max(answer, leftCount + rightCount)
                }
            }
        }
        for (i in 0 until counts.size) {
            val (v, count) = counts[i]
            if (v == 1) {
                answer = max(answer, count)
            }
        }
        return answer
    }
}

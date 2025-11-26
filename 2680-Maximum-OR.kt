import java.lang.Long.max

class Solution {
    fun maximumOr(nums: IntArray, k: Int): Long {
        val bitCounts = Array(64) { 0 }
        for (num in nums) {
            for (i in 0..31) {
                if (num and (1 shl i) != 0) {
                    bitCounts[i] += 1
                }
            }
        }

        var answer = 0L

        for (num in nums) {
            for (i in 0..31) {
                if (num and (1 shl i) != 0) {
                    bitCounts[i] -= 1
                    bitCounts[i + k] += 1
                }
            }

            var v = 0L
            for (i in 0 until 50) {
                if (bitCounts[i] != 0) {
                    v = v or (1L shl i)
                }
            }
            answer = max(answer, v)

            for (i in 0..31) {
                if (num and (1 shl i) != 0) {
                    bitCounts[i] += 1
                    bitCounts[i + k] -= 1
                }
            }
        }

        return answer
    }
}

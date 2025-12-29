import kotlin.math.abs

class Solution {
    fun circularArrayLoop(nums: IntArray): Boolean {
        for (i in nums.indices) {
            if (abs(nums[i]) % nums.size == 0) {
                nums[i] = 0
            }
        }

        val visitedBit = 1 shl 20

        for (i in nums.indices) {
            if (nums[i] == 0) {
                continue
            }
            val absNum = abs(nums[i])
            if (absNum.and(visitedBit) == visitedBit) {
                continue
            }

            var current = i
            val isPositive = nums[current] > 0

            var count = 1
            while(count <= nums.size) {
                val absCurrentNum = abs(nums[current])
                nums[current] = if(isPositive) absCurrentNum.or(visitedBit) else -(absCurrentNum.or(visitedBit))
                val next = (current + (nums[current].xor(visitedBit)) + nums.size * 10_000) % nums.size

                current = if (isPositive) {
                    if (nums[next] > 0) {
                        next
                    } else {
                        count = -1
                        break
                    }
                } else {
                    if (nums[next] < 0) {
                        next
                    } else {
                        count = -1
                        break
                    }
                }
                count += 1
            }

            if (count == nums.size + 1) {
                return true
            }
        }
        return false
    }

}

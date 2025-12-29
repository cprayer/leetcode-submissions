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

            var current = i
            val isPositive = nums[current] > 0

            var count = 0
            while(count < nums.size) {
                if (abs(nums[current]).and(visitedBit) == visitedBit) {
                    count = -1
                    break
                }

                val next = (current + nums[current] + nums.size * 10_000) % nums.size

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

            if (count == nums.size) {
                return true
            }

            current = i
            while(count < nums.size) {
                val currentNum = nums[current]
                if (abs(currentNum).and(visitedBit) == visitedBit) {
                    break
                }
                val next = (current + currentNum + nums.size * 10_000) % nums.size
                nums[current] = if (currentNum > 0) currentNum.or(visitedBit) else -(abs(currentNum).or(visitedBit))

                current = if (isPositive) {
                    if (nums[next] > 0) {
                        next
                    } else {
                        break
                    }
                } else {
                    if (nums[next] < 0) {
                        next
                    } else {
                        break
                    }
                }
            }
        }
        return false
    }

}

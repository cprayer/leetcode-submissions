import java.lang.Integer.max

class Solution {
    fun minIncrementForUnique(nums: IntArray): Int {
        nums.sort()

        var answer = 0
        var current = 0
        val inserted = mutableSetOf<Int>()
        for (num in nums) {
            current = max(current, num)
            while (inserted.contains(current)) {
                current += 1
            }
            inserted += current
            answer += (current - num)
        }
        return answer
    }
}

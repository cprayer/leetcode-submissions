import java.lang.Integer.max

class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        fun getAnswer(isStartPlus: Boolean): Int {
            var isCurrentPlus = isStartPlus
            var current = nums[0]
            var index = 0
            var answer = 0
            while(index < nums.size) {
                when (isCurrentPlus) {
                    true -> {
                        while (index < nums.size && current <= nums[index]) {
                            current = nums[index]
                            index += 1
                        }
                        isCurrentPlus = false
                    }
                    false -> {
                        while (index < nums.size && current >= nums[index]) {
                            current = nums[index]
                            index += 1
                        }
                        isCurrentPlus = true
                    }
                }
                answer += 1
            }
            return answer
        }

        return max(getAnswer(false), getAnswer(true))
    }
}

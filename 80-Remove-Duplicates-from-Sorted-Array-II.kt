class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var currentIndex = 0
        while (currentIndex < nums.size) {
            val num = nums[currentIndex]
            var count = 0
            while (currentIndex < nums.size && num == nums[currentIndex]) {
                count += 1
                if (count >= 3) {
                    nums[currentIndex] = Int.MIN_VALUE
                }
                currentIndex += 1
            }
        }

        var writeIndex = 0
        for (num in nums) {
            if (num == Int.MIN_VALUE) {
                continue
            }
            nums[writeIndex] = num
            writeIndex += 1
        }

        return writeIndex
    }
}


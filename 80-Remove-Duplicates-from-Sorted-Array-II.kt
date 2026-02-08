class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var removedCount = 0
        var currentIndex = 0
        while (currentIndex < nums.size) {
            val num = nums[currentIndex]
            var count = 0
            while (currentIndex < nums.size && num == nums[currentIndex]) {
                count += 1
                if (count >= 3) {
                    nums[currentIndex] = Int.MIN_VALUE
                    removedCount += 1
                }
                currentIndex += 1
            }
        }

        var removedIndex = nums.indexOfFirst { it == Int.MIN_VALUE }
        var nonRemovedIndex = removedIndex
        
        if (removedIndex == -1) {
            return nums.size
        }
        
        while (nonRemovedIndex < nums.size) {
            while (nonRemovedIndex < nums.size && nums[nonRemovedIndex] == Int.MIN_VALUE) {
                nonRemovedIndex += 1
            }
            if (nonRemovedIndex < nums.size) {
                nums[removedIndex] = nums[nonRemovedIndex]
                removedIndex += 1
                nonRemovedIndex += 1
            }
        }
        return nums.size - removedCount
    }
}


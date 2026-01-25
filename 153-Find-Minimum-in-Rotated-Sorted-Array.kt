class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums.first()
        }
        
        if (nums.first() < nums.last()) {
            return nums.first()
        }

        var l = 0
        var r = nums.size

        while(l + 1 < r) {
            var m = (l + r) / 2
            if (nums.first() < nums[m]) {
                l = m
            } else {
                r = m
            }
        }
        
        return nums[l + 1]
    }
}

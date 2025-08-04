class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums[0] == target) {
            return 0
        }

        if (nums.last() == target) {
            return nums.size - 1
        }


        var l = 0
        var r = nums.size - 1

        while (l + 1 < r) {
            val m = (l + r) / 2
            if (nums[m] == target) return m
            else if (nums[l] < nums[m]) {
                if (nums[l] < target && target < nums[m]) {
                    r = m
                } else {
                    l = m
                }
            } else {
                if (nums[m] < target && target < nums[r]) {
                    l = m
                } else {
                    r = m
                }
            }
        }

        if (nums[l] == target) {
            return l
        }
        if (nums[r] == target) {
            return r
        }


        return -1
    }
}

import java.lang.Integer.min

class Solution {
    fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
        var s = 0
        for (group in groups) {
            var found = false
            for (i in s until nums.size) {
                val target = nums.sliceArray(i until min(nums.size, i + group.size))
                if (group.contentEquals(target)) {
                    s = i + group.size
                    found = true
                    break
                }
            }
            if (!found) {
                return false
            }
        }
        return true
    }
}

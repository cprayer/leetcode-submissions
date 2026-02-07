class Solution {
    fun minimumK(nums: IntArray): Int {
        var l = 0L
        var r = 100_000L

        while (l + 1 < r) {
            val m = (l + r) / 2
            var sum = 0L
            for (num in nums) {
                sum += (num + m - 1) / m
            }

            if (sum <= m * m) {
                r = m
            } else {
                l = m
            }
        }
        
        return r.toInt()
    }
}

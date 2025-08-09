class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        if (k == 0) {
            val counts = nums.groupBy { it }
                .map { (key, values) -> key to values.count() }
                .toMap()
            return counts.values.count { it >= 2 }
        }

        val counts = nums.toSet()
        return counts.count { counts.contains(it + k) }
    }
}

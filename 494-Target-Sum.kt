class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val currents = mutableMapOf<Int, Int>()
        currents[0] = 1

        for (num in nums) {
            val nexts = mutableMapOf<Int, Int>()
            for ((k, v) in currents) {
                nexts[k + num] = nexts.getOrDefault(k + num, 0) + v
                nexts[k - num] = nexts.getOrDefault(k - num, 0) + v
            }

            currents.clear()
            currents.putAll(nexts)
        }

        return currents.getOrDefault(target, 0)
    }
}

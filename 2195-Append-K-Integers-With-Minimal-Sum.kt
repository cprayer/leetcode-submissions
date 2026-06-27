class Solution {
    fun minimalKSum(nums: IntArray, k: Int): Long {
        val items = nums.toMutableList()
        items.add(0)
        items.add(Int.MAX_VALUE)
        items.sort()

        var uniquePositiveSum = 0L
        var remain = k

        for (i in 1 until items.size) {

            val left = items[i - 1] + 1
            val right = Math.min(items[i] - 1, left + remain - 1)

            if (left > right) {
                continue
            }

            uniquePositiveSum += (left + right).toLong() * (right - left + 1) / 2
            remain -= (right - left + 1)
        }


        return uniquePositiveSum
    }
}

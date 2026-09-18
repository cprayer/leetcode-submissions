class Solution {
    fun maximumSum(nums: IntArray): Int {
        val buckets = mutableMapOf<Int, PriorityQueue<Int>>()
        var ans = -1
        for (num in nums) {
            val pq = buckets.computeIfAbsent(sumOfDigits(num)) { PriorityQueue() }
            pq.add(num)
            if (pq.size > 2) {
                pq.poll()
            }
            if (pq.size == 2) {
                ans = max(ans, pq.sum())
            }
        }
        return ans
    }

    fun sumOfDigits(num: Int): Int {
        var v = num
        var let = 0
        while (v > 0) {
            let += v % 10
            v /= 10;
        }
        return let
    }
}

class Solution {
    fun numTriplets(nums1: IntArray, nums2: IntArray): Int {
        val nums1Counts = mutableMapOf<Int, Int>()
        for (num in nums1) {
            nums1Counts[num] = nums1Counts.getOrDefault(num, 0) + 1
        }

        val nums2Counts = mutableMapOf<Int, Int>()
        for (num in nums2) {
            nums2Counts[num] = nums2Counts.getOrDefault(num, 0) + 1
        }

        return getAnswer(nums1Counts, nums2, nums2Counts) + getAnswer(nums2Counts, nums1, nums1Counts)
    }

    fun getAnswer(nums1Counts: Map<Int, Int>, nums2: IntArray, nums2Counts: Map<Int, Int>): Int {
        var answer = 0
        for ((num1, count) in nums1Counts) {
            val alreadyProcessedNums = mutableSetOf<Int>()
            for (left in nums2) {
                val pow2 = num1.toLong() * num1
                if (pow2 % left != 0L) {
                    continue
                }
                if (alreadyProcessedNums.contains(left)) {
                    continue
                }

                val right = (pow2 / left).toInt()

                answer += if (left != right) {
                    count * nums2Counts.getOrDefault(left, 0) * nums2Counts.getOrDefault(right, 0)
                } else {
                    count * nums2Counts.getOrDefault(left, 0) * (nums2Counts.getOrDefault(left, 0) - 1) / 2
                }

                alreadyProcessedNums.add(left)
                alreadyProcessedNums.add(right)
            }
        }
        return answer
    }
}

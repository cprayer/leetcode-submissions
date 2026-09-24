class Solution {
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0) {
            return false
        }

        val counts = mutableMapOf<Int, Int>()
        for (num in nums) {
            counts[num] = counts.getOrDefault(num, 0) + 1
        }

        val startPoints = mutableListOf<Int>()
        for (key in counts.keys) {
            if (counts.getOrDefault(key - 1, 0) == 0) {
                startPoints.add(key)
            }
        }

        for (start in startPoints) {
            val candidates = ArrayDeque<Int>()
            candidates.add(start)
            while (candidates.isNotEmpty()) {
                val current = candidates.removeFirst()
                val currentCount = counts.getOrDefault(current, 0)
                if (currentCount == 0) {
                    continue
                }

                var isAdded = false
                for (i in 0 until k) {
                    val count = counts.getOrDefault(current + i, 0)
                    if (count < currentCount) {
                        return false
                    }
                    counts[current + i] = count - currentCount
                    if (count - currentCount > 0) {
                        candidates.add(current + i)
                        isAdded = true
                    }
                }
                if (!isAdded) {
                    if (counts.getOrDefault(current + k, 0) > 0) {
                        candidates.add(current + k)
                    }
                }
            }
        }

        for (num in nums) {
            if (counts[num] != 0) {
                return false
            }
        }

        return true
    }
}

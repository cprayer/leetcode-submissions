class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()

        var left = -1
        var right = 1_000_000_009

        while (left + 1 < right) {
            val mid = (left + right) / 2
            var last = 0
            var count = 1
            for (i in 1 until position.size) {
                if (position[i] - position[last] >= mid) {
                    last = i
                    count += 1
                }
            }

            if (count >= m) {
                left = mid
            } else {
                right = mid
            }
        }

        return left
    }
}

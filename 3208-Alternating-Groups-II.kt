class Solution {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        var answer = 0
        var count = 0
        for (i in 0 until k) {
            if (i == 0 || i == k - 1) {
                continue
            }

            if (colors[i] != colors[i - 1] && colors[i] != colors[i + 1]) {
                count += 1
            }
        }
        if (count == k - 2) {
            answer += 1
        }

        val size = colors.size

        fun safeIndex(index: Int) = (index + size * 2) % size

        for (i in k until size + k - 1) {
            val left = i - k + 1
            if (colors[safeIndex(left)] != colors[safeIndex(left - 1)] &&
                colors[safeIndex(left)] != colors[safeIndex(left + 1)]
            ) {
                count -= 1
            }


            val right = i - 1
            if (colors[safeIndex(right)] != colors[safeIndex(right - 1)] &&
                colors[safeIndex(right)] != colors[safeIndex(right + 1)]
            ) {
                count += 1
            }

            if (count == k - 2) {
                answer += 1
            }
        }

        return answer
    }
}

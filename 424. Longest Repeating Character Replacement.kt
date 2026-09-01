import java.lang.Integer.max

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val indexes = Array(26) { mutableListOf<Int>() }
        for ((index, ch) in s.withIndex()) {
            indexes[ch - 'A'].add(index)
        }

        val length = s.length
        var ans = 0
        for (i in 0 until 26) {
            var left = 0
            var remain = k
            for (right in 0 until length) {
                remain -= if (s[right] - 'A' == i) 0 else 1
                while (remain < 0 && left < length) {
                    remain += if (s[left] - 'A' == i) 0 else 1
                    left += 1
                }
                ans = max(ans, right - left + 1)
            }
        }

        return ans
    }
}

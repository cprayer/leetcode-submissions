import java.lang.Integer.max

class Solution {
    fun findSubstringInWraproundString(s: String): Int {
        val maxCounts = IntArray(26) { 0 }
        var currentIndex = 0
        var currentLength = 1
        for (i in s.indices) {
            if (currentIndex == i) {
                continue
            }
            
            if ((s[i] == 'a' && s[i - 1] == 'z') || (s[i] - s[i - 1] == 1)) {
                currentLength += 1
            } else {
                for (x in 0 until 26) {
                    val ch = (s[currentIndex] - 'a' + x) % 26
                    maxCounts[ch] = max(maxCounts[ch], currentLength - x)
                }
                currentIndex = i
                currentLength = 1
            }
        }

        for (x in 0 until 26) {
            val ch = (s[currentIndex] - 'a' + x) % 26
            maxCounts[ch] = max(maxCounts[ch], currentLength - x)
        }

        return maxCounts.sum()
    }
}

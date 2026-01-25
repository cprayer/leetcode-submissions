class Solution {
    fun numDecodings(s: String): Int {
        val counts = IntArray(s.length + 1)
        counts[0] = 1

        for (i in s.indices) {
            if (s[i] != '0') {
                counts[i + 1] += counts[i]
            }

            val previousCh = s.getOrNull(i - 1) ?: continue
            val currentCh = s[i]
            val s = "$previousCh$currentCh"
            if (s in "10".."26") {
                counts[i + 1] += counts[i - 1]
            }
        }

        return counts[s.length]
    }
}

class Solution {
    fun beautySum(s: String): Int {
        var ans = 0
        for (i in s.indices) {
            val counts = mutableMapOf<Char, Int>()
            for (j in i until s.length) {
                val ch = s[j]
                counts[ch] = counts.getOrDefault(ch, 0) + 1
                ans += counts.values.max() - counts.values.min()
            }
        }
        
        return ans
    }
}

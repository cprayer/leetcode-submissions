class Solution {
    fun minimumPushes(word: String): Int {
        val counts = IntArray(26) { 0 }
        for (ch in word) {
            counts[ch - 'a'] += 1
        }

        return counts.filter { it != 0 }
            .sortedByDescending { it }
            .mapIndexed { index, count ->
                ((index / 8) + 1) * count
            }.sum()
    }
}

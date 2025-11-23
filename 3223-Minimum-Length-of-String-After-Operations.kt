class Solution {
    fun minimumLength(s: String): Int {
        val counts = Array(26) { 0 }
        for (char in s) {
            counts[char - 'a'] += 1
        }

        val answer = counts.sumOf { count ->
            if (count == 0) {
                0
            } else {
                2 - (count % 2)
            }
        }
        return answer
    }
}

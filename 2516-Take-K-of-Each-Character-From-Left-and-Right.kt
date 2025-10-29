import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun takeCharacters(s: String, k: Int): Int {
        if (k == 0) {
            return 0
        }

        val counts = IntArray(3) { 0 }
        for (ch in s) {
            counts[ch - 'a'] += 1
        }
        
        var answer = Int.MAX_VALUE
        var right = s.length
        for (left in s.length - 1 downTo -1) {
            while (left + 1 < right && counts.any { it < k }) {
                val rightCh = s[right - 1] - 'a'
                counts[rightCh] = counts[rightCh] + 1
                right -= 1
            }
            if (counts.all { it >= k }) {
                answer = min(answer, left + 1 + s.length - right)
            }
            if (left >= 0) {
                val leftCh = s[left] - 'a'
                counts[leftCh] = counts[leftCh] - 1
            }
        }

        return if (answer != Int.MAX_VALUE) {
            answer
        } else {
            -1
        }
    }
}

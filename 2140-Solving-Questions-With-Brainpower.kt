import java.lang.Long.max

class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val dp = Array(questions.size) { -1L }

        fun getAnswer(current: Int): Long {
            if (current >= questions.size) {
                return 0
            }
            if (dp[current] != -1L) {
                return dp[current]
            }

            val (points, brainpower) = questions[current]
            dp[current] = max(getAnswer(current + 1), points + getAnswer(current + brainpower + 1))
            return dp[current]
        }
        
        return getAnswer(0)
    }
}

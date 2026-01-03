import java.lang.Integer.min

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length) { IntArray(word2.length) { -1 } }
        
        fun getAnswer(i: Int, j: Int): Int {
            if (i == word1.length) {
                return word2.length - j
            }
            if (j == word2.length) {
                return word1.length - i
            }
            
            if (dp[i][j] != -1) {
                return dp[i][j]
            }
            
            dp[i][j] = if (word1[i] == word2[j]) {
                getAnswer(i + 1, j + 1)
            } else {
                1 + min(getAnswer(i + 1, j), getAnswer(i, j + 1))
            } 
            
            return dp[i][j]
        }
        
        return getAnswer(0, 0)
    }
}

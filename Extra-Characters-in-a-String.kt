import java.lang.Integer.min

class Solution {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val dp = MutableList(s.length) { -1 }
        val answer = getAnswer(s, dictionary, 0, dp)
        return answer
    }

    private fun getAnswer(s: String, dictionary: Array<String>, currentIndex: Int, dp: MutableList<Int>): Int {
        if (currentIndex == s.length) {
            return 0
        }
        if (currentIndex > s.length) {
            return s.length
        }
        if (dp[currentIndex] != -1) {
            return dp[currentIndex]
        }

        var ret = Int.MAX_VALUE
        for (word in dictionary) {
            if (s.substring(currentIndex).startsWith(word)) {
                ret = min(ret, getAnswer(s, dictionary, currentIndex + word.length, dp))
            }
        }

        ret = min(ret, getAnswer(s, dictionary, currentIndex + 1, dp) + 1)
        dp[currentIndex] = ret
        return ret
    }
}

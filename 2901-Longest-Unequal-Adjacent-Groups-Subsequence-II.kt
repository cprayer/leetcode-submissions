class Solution {
    fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        val wordsSize = words.size
        val dp = IntArray(wordsSize) { -1 }
        val dpPaths = IntArray(wordsSize) { -1 }

        fun getAnswer(current: Int): Int {
            if (current == wordsSize) {
                return 0
            }

            if (dp[current] != -1) {
                return dp[current]
            }

            var ret = 0
            for (i in current + 1 until wordsSize) {
                val currentWord = words[current]
                val targetWord = words[i]

                if (groups[current] == groups[i]) {
                    continue
                }
                if (currentWord.length != targetWord.length) {
                    continue
                }

                val wordLength = currentWord.length
                var count = 0
                for (j in 0 until wordLength) {
                    if (currentWord[j] != targetWord[j]) {
                        count += 1
                    }
                }

                if (count == 1) {
                    if (ret < getAnswer(i) + 1) {
                        ret = getAnswer(i) + 1
                        dpPaths[current] = i
                    }
                }
            }
            dp[current] = ret
            return ret
        }

        var maxVal = 0
        var maxValStartIndex = 0

        for (i in 0 until wordsSize) {
            if (maxVal < getAnswer(i)) {
                maxVal = getAnswer(i)
                maxValStartIndex = i
            }
        }

        val answer = mutableListOf<String>()
        var current = maxValStartIndex
        while (current != -1) {
            answer.add(words[current])
            current = dpPaths[current]
        }

        return answer
    }
}

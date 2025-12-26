class Solution {
    fun countOfSubstrings(word: String, k: Int): Int {
        val n = word.length
        var answer = 0
        for (i in 0 until n) {
            for(j in i until n) {
                val substring = word.substring(i, j + 1)
                if (!vowels.all { char -> substring.any { char == it } }) {
                    continue
                }
                if (substring.count { !vowels.contains(it) } != k) {
                    continue
                }
                answer += 1
            }
        }
        return answer
    }

    companion object {
        val vowels = listOf('a', 'e', 'i', 'o', 'u')
    }
}

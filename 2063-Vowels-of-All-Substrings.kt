class Solution {
    fun countVowels(word: String): Long {
        var answer = 0L
        var count = 0L
        var vowels = listOf('a', 'e', 'i', 'o', 'u')
        for (i in word.indices) {
            if (vowels.contains(word[i])) {
                count += (i + 1)
            }
            answer += count
        }
        return answer
    }
}

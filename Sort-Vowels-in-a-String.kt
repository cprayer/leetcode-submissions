class Solution {
    fun sortVowels(s: String): String {
        val counts = mutableMapOf<Char, Int>()
        val vowels = listOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
        for (char in s) {
            if (char in vowels) {
                counts[char] = counts.getOrDefault(char, 0) + 1
            }
        }

        return s.map { char ->
            if (char in vowels) {
                val first = vowels.first { counts.getOrDefault(it, 0) != 0 }
                counts[first] = counts.getOrDefault(first, 0) - 1
                first
            } else {
                char
            }
        }.joinToString("")
    }
}

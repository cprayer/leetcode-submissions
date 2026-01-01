import java.lang.Integer.max

class Solution {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        val length = croakOfFrogs.length
        if (length % 5 != 0) {
            return -1
        }
        val counts = mutableMapOf<Char, Int>()
        val mappings = mapOf(
            'r' to 'c',
            'o' to 'r',
            'a' to 'o',
            'k' to 'a',
        )

        var answer = 0
        for (char in croakOfFrogs) {
            when (char) {
                'c' -> {
                    counts[char] = counts.getOrDefault(char, 0) + 1
                }
                else -> {
                    if (!mappings.containsKey(char)) {
                        return -1
                    }

                    val previousCh = mappings.getValue(char)
                    val count = counts.getOrDefault(previousCh, 0)
                    if (count == 0) {
                        return -1
                    }

                    counts[char] = counts.getOrDefault(char, 0) + 1
                    counts[previousCh] = counts.getOrDefault(previousCh, 0) - 1
                }
            }

            answer = max(answer, intermediateChars.sumOf { counts.getOrDefault(it, 0) })
        }

        if (intermediateChars.map { counts.getOrDefault(it, 0) }.any { it != 0 }) {
            return -1
        }
        if (counts.getOrDefault('k', 0) != length / 5) {
            return -1
        }

        return answer
    }

    companion object {
        private val intermediateChars = listOf('c', 'r', 'o', 'a')
    }
}

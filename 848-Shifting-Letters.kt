class Solution {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        val stringBuilder = StringBuilder()
        var current = 0
        for (i in s.length - 1 downTo 0) {
            current += shifts[i]
            current %= 26
            stringBuilder.append('a' + (s[i] - 'a' + current) % 26)
        }

        return stringBuilder.reversed().toString()
    }
}

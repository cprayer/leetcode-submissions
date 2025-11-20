class Solution {
    fun reverseWords(s: String): String {
        return s.trim().split(" ").filter { it.isNotBlank() }.reversed().joinToString(" ")
    }
}

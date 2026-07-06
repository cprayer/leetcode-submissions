class Solution {
    fun letterCasePermutation(s: String): List<String> {
        val answer = mutableListOf<String>()
        answer.add(s)
        for (i in s.indices) {
            val ch = s[i]
            if (ch in '0'..'9') {
                continue
            }

            val reversed = if (ch.isLowerCase()) {
                ch.uppercase()
            } else {
                ch.lowercase()
            }

            val nextItems = mutableListOf<String>()
            for (item in answer) {
                nextItems.add(item.substring(0, i) + reversed + item.substring(i + 1))
            }
            answer.addAll(nextItems)
        }
        return answer
    }
}

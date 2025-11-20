class Solution {
    fun stringSequence(target: String): List<String> {
        val answer = mutableListOf<String>()
        val stringBuilder = StringBuilder()
        for (ch in target) {
            val current = stringBuilder.toString()
            for (next in 'a'..ch) {
                answer.add(current + next)
            }
            stringBuilder.append(ch)
        }
        return answer
    }
}

import java.lang.StringBuilder

class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val positions = ArrayDeque<Int>()
        val removedPositions = mutableSetOf<Int>()

        for ((index, ch) in s.withIndex()) {
            when (ch) {
                '(' -> {
                    positions.add(index)
                }
                ')' -> {
                    if (positions.isNotEmpty()) {
                        positions.removeLast()
                    } else {
                        removedPositions.add(index)
                    }
                }
                else -> {}
            }
        }
        removedPositions.addAll(positions)
        
        val answer = StringBuilder()
        for ((index, ch) in s.withIndex()) {
            if (removedPositions.contains(index)) {
                continue
            }
            answer.append(ch)
        }

        return answer.toString()
    }
}

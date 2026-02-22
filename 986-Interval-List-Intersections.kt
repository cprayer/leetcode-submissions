import java.lang.Integer.max
import kotlin.math.sign

class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        var firstIndex = 0
        var secondIndex = 0

        val answer = mutableListOf<IntArray>()
        while (firstIndex < firstList.size || secondIndex < secondList.size) {
            val (firstStart, firstEnd) = firstList.getOrNull(firstIndex) ?: intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
            val (secondStart, secondEnd) = secondList.getOrNull(secondIndex) ?: intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)

            if (firstEnd <= secondEnd) {
                if (firstEnd >= secondStart) {
                    answer.add(intArrayOf(max(firstStart, secondStart) ,firstEnd))
                }
                firstIndex += 1
            } else {
                if (secondEnd >= firstStart) {
                    answer.add(intArrayOf(max(firstStart, secondStart) ,secondEnd))
                }
                secondIndex += 1
            }
        }

        return answer.toTypedArray()
    }
}

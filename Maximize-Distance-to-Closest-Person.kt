import java.lang.Integer.max

class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        val oneIndexes =
            seats.mapIndexed { index, i -> index to i }.filter { (_, i) -> i == 1 }.map { (index, _) -> index }

        var answer = max(oneIndexes[0], seats.size - 1 - oneIndexes.last())
        for (i in 1 until oneIndexes.size) {
            answer = max(answer, (oneIndexes[i] - oneIndexes[i - 1]) / 2)
        }

        return answer
    }
}

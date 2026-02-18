import java.lang.Long.min

class Solution {
    fun minimumRemoval(beans: IntArray): Long {
        beans.sort()
        var leftSum = 0L
        var rightSum = beans.sumOf { it.toLong() }

        var answer = Long.MAX_VALUE
        for (i in beans.indices) {
            val bean = beans[i].toLong()
            val sum = leftSum + rightSum - (beans.size - i) * bean
            answer = min(answer, sum)

            leftSum += bean
            rightSum -= bean
        }

        return answer
    }
}

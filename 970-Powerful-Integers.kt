class Solution {
    fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        if (x == 1 && y == 1) {
            return if (bound >= 2) {
                listOf(2)
            } else {
                listOf()
            }
        }

        if (x == 1 || y == 1) {
            val maxV = Math.max(x, y)
            val answer = mutableListOf<Int>()
            var current = 1
            while(current + 1 <= bound) {
                answer.add(current + 1)
                current *= maxV
            }
            return answer
        }

        val answer = mutableSetOf<Long>()
        var currentX = 1L
        for (i in 0 until 20) {
            var currentY = 1L
            for (j in 0 until 20) {
                val sum = currentX + currentY
                if (sum <= bound) {
                    answer.add(sum)
                }
                currentY *= y
                if (currentY > bound) {
                    break
                }
            }
            currentX *= x
            if (currentX > bound) {
                break
            }
        }

        return answer.map { it.toInt() }.toList()
    }
}

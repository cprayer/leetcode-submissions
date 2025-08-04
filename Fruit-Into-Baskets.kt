import java.lang.Integer.max

class Solution {
    fun totalFruit(fruits: IntArray): Int {
        var l = 0
        var r = 0

        val counts = mutableMapOf<Int, Int>()
        var number = 0
        var answer = Int.MIN_VALUE
        while(l < fruits.size) {
            while (r < fruits.size && counts.size < 3) {
                val v = fruits[r]
                counts[v] = counts.getOrDefault(v, 0) + 1
                number += 1
                if (counts.size < 3) {
                    answer = max(answer, number)
                }
                r += 1
            }

            val v = fruits[l]
            counts[v] = counts.getOrDefault(v, 0) - 1
            number -= 1
            if (counts[v] == 0) {
                counts.remove(v)
            }
            l += 1
        }

        return answer
    }
}

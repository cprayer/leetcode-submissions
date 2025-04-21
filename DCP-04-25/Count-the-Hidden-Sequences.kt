import java.lang.Long.max
import java.lang.Long.min

class Solution {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var min = 0L
        var max = 0L
        var current = 0L

        for (difference in differences) {
            current += difference
            min = min(min, current)
            max = max(max, current)
        }

        val count = (upper - lower) - (max - min) + 1
        if (count > 0) {
            return count.toInt()
        } else {
            return 0
        }
    }
}
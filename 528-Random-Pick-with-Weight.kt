import java.util.*
import kotlin.random.Random

class Solution(w: IntArray) {

    private var sum = 0

    private val treeMap = TreeMap<Int, Int>().also {
        for ((i, v) in w.withIndex()) {
            sum += v
            it[sum] = i
        }
    }

    fun pickIndex(): Int {
        val current = treeMap.tailMap(Random.nextInt(sum) + 1)
        return treeMap.getValue(current.firstKey())
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */

import kotlin.math.abs
import kotlin.random.Random

class Solution(private val rects: Array<IntArray>) {

    private val areas = LongArray(rects.size) {
        val (a, b, x, y) = rects[it]
        (abs(a - x) + 1L) * (abs(b - y) + 1L)
    }
    private val areaSum = areas.sum()
    private val areaPrefixSums = LongArray(rects.size + 1)

    init {
        for (i in rects.indices) {
            areaPrefixSums[i + 1] += areaPrefixSums[i] + areas[i]
        }
    }


    fun pick(): IntArray {
        val selected = Random.nextLong(areaSum)
        var left = 0
        var right = rects.size + 1

        while (left + 1 < right) {
            val mid = (left + right) / 2
            if (areaPrefixSums[mid] <= selected) {
                left = mid
            } else {
                right = mid
            }
        }

        val (a, b, x, y) = rects[left]

        val remain = selected - areaPrefixSums[left]
        val w = abs(a - x) + 1L
        val py = (remain / w).toInt()
        val px = (remain % w).toInt()

        return intArrayOf(a + px, b + py)
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(rects)
 * var param_1 = obj.pick()
 */

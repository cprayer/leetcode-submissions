import java.lang.Integer.min
import kotlin.math.abs

class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val diffX = abs(sx - fx)
        val diffY = abs(sy - fy)

        val shortLength = min(diffX, diffY)

        val distance = diffX + diffY - shortLength
        if (distance == 0 && t == 1) {
            return false
        }
        return distance <= t
    }
}
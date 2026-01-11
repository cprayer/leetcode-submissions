class Solution {
    fun maximumGroups(grades: IntArray): Int {
        var l = 0L
        var r = 1_000_000L

        while (l + 1 < r) {
            val m = (l + r) / 2
            if (m * (m + 1) / 2 <= grades.size) {
                l = m
            } else {
                r = m
            }
        }
        
        return l.toInt()
    }
}

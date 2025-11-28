class Solution {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var l = 0L
        var r = (1L shl 60)
        while(l + 1 < r) {
            val m = (l + r) / 2
            var sum = 0L
            for (t in time) {
                sum += (m / t)
                if (sum >= totalTrips) {
                    r = m
                    break
                }
            }
            if (sum < totalTrips) {
                l = m
            }
        }
        return r
    }
}

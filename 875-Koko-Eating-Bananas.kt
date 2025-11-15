class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 0
        var r = 1_000_000_009
        while(l + 1 < r) {
            val m = (l + r) / 2
            var s = 0L
            for (banana in piles) {
                s += (banana + m - 1) / m
            }

            if (s <= h) {
                r = m
            } else {
                l = m
            }
        }

        return r
    }
}

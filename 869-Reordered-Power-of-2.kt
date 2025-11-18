class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        val nCounts = countDigits(n)
        for (v in 0..30) {
            val vCounts = countDigits((1).shl(v))
            if (nCounts.contentEquals(vCounts)) {
                return true
            }
        }
        return false
    }

    fun countDigits(v: Int): IntArray {
        val counts = IntArray(10)
        var remain = v
        while (remain > 0) {
            counts[remain % 10] += 1
            remain /= 10
        }
        return counts
    }
}

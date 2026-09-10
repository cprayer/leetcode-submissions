class Solution {
    fun sumDecoded(nums: LongArray): Int {
        var sum = 0L

        for (num in nums) {
            val width = (num % 10).toInt()
            val d = num / 10
            val dString = d.toString()
            val x = dString.substring(0, width).toLong()
            val y = dString.substring(width).toLong()

            sum += powWithMod(x, y)
            sum %= MOD
        }

        return sum.toInt()
    }

    fun powWithMod(x: Long, y: Long): Long {
        var result = 1L
        var current = x % MOD

        for (i in 0 until 63) {
            if(y.and(1L shl i) != 0L) {
                result *= current
                result %= MOD
            }

            current *= current
            current %= MOD
        }

        return result
    }

    companion object {
        const val MOD = 1_000_000_000 + 7
    }
}

class Solution {
    fun minNonZeroProduct(p: Int): Int {
        if (p == 1) {
            return 1
        }

        var answer = (1L shl p) - 1
        answer %= MOD

        var m = ((1L shl p) - 2) % MOD
        var am = 1L
        for (i in 0 until p - 1) {
            am *= m
            am %= MOD

            m *= m
            m %= MOD
        }

        return ((answer * am) % MOD).toInt()
    }

    companion object {
        const val MOD = 1_000_000_007
    }
}

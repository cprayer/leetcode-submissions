class Solution {
    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        val dp = mutableMapOf<Int, Int>()

        fun getAnswer(current: Int, remain: Int): Int {
            if (remain == 0) {
                return if (current == endPos) {
                    1
                } else {
                    0
                }
            }

            val key = current * 10000 + remain
            if (dp.contains(key)) {
                return dp.getValue(key)
            }

            dp[key] = (getAnswer(current - 1, remain - 1) + getAnswer(current + 1, remain - 1)) % MOD
            return dp.getValue(key)
        }
        
        return getAnswer(startPos, k)
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}

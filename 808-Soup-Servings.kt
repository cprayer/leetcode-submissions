class Solution {
    fun soupServings(n: Int): Double {
        
        if (n >= 5000) return 1.0
        
        val dp = Array(n + 1) { DoubleArray(n + 1) { -1.0 } }

        fun calc(a: Int, b: Int): Double {
            if (dp[a][b] != -1.0) {
                return dp[a][b]
            }
            if (a == 0 && b == 0) {
                return 0.5
            }
            if (a == 0) {
                return 1.0
            }
            if (b == 0) {
                return 0.0
            }
            var ans = calc(max(a - 100, 0), b) * 0.25
            ans += calc(max(a - 75, 0), max(b - 25, 0)) * 0.25
            ans += calc(max(a - 50, 0), max(b - 50, 0)) * 0.25
            ans += calc(max(a - 25, 0), max(b - 75, 0)) * 0.25
            dp[a][b] = ans
            return ans
        }

        return calc(n, n)
    }
}

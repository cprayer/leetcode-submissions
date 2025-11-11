import java.math.BigInteger

class Solution {
    fun longestSubsequence(s: String, k: Int): Int {
        var count = 0
        var current = s
        while(BigInteger(current, 2) > BigInteger.valueOf(k.toLong())) {
            count += 1
            current = current.replaceFirst('1', '0')
        }

        return s.length - count
    }
}

import java.math.BigInteger

class Solution {
    fun longestSubsequence(s: String, k: Int): Int {
        val farLeftOne = Int.SIZE_BITS - k.countLeadingZeroBits()
        
        if(s.length < farLeftOne) {
            return s.length
        }
        
        val count = s.substring(0, s.length - farLeftOne).count { it == '1' }
        val supplement =
            if (BigInteger(s.substring(s.length - farLeftOne, s.length), 2) > BigInteger.valueOf(k.toLong())) 1 else 0

        return s.length - (count + supplement)
    }
}

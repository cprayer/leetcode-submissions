import java.math.BigInteger

class Solution {
    fun superPow(a: Int, b: IntArray): Int {
        val m = BigInteger.valueOf(1337)
        return BigInteger.valueOf(a.toLong()).modPow(BigInteger(b.joinToString("")), m).toInt()
    }
}

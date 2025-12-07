import java.math.BigInteger

class Solution {
    fun multiply(num1: String, num2: String): String {
        val value = BigInteger(num1) * BigInteger(num2)
        return value.toString()
    }
}

class Solution {
    fun mirrorReflection(p: Int, q: Int): Int {
        val g = gcd(p, q)
        val t = p * q / g
        
        val a = (t / q) % 2
        val b = (t / p) % 2
        
        return when {
            (a == 0 && b == 0) || (a == 1 && b == 1) -> 1
            (a == 0 && b == 1) -> 2
            else -> 0
        }
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }

        return gcd(b, a % b)
    }
}

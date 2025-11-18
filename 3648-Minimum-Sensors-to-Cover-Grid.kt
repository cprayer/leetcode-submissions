class Solution {
    fun minSensors(n: Int, m: Int, k: Int): Int {
        val l = (k * 2 + 1)
        return ((n + l - 1) / l) * ((m + l - 1) / l)
    }
}

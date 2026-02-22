class Solution {
    fun makeStringsEqual(s: String, target: String): Boolean {
        val length = s.length

        if (s == target) {
            return true
        }

        if (s.count { it == '0' } == length || target.count { it == '0' } == length) {
            return falsea
        }

        return true
    }
}

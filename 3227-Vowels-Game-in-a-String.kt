class Solution {
    fun doesAliceWin(s: String): Boolean {
        val c = s.count { vowels.contains(it) }
        if (c == 0) {
            return false
        }
        return true
    }

    companion object {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
    }
}

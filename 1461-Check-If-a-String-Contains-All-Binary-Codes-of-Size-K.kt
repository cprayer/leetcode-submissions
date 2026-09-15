class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        if (s.length < k) {
            return false
        }

        val m = 1 shl k
        val items = mutableSetOf<Int>()
        var current = 0

        for(i in 0 until k - 1) {
            current *= 2
            current += if (s[i] == '1') 1 else 0
            current %= m
        }

        for (i in k - 1 until s.length) {
            current *= 2
            current += if (s[i] == '1') 1 else 0
            current %= m
            items.add(current)
        }

        return items.size == m
    }
}


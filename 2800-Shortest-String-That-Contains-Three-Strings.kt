import java.lang.Integer.min

class Solution {
    fun minimumString(a: String, b: String, c: String): String {
        val items = listOf(a, b, c)
        val candidates = items.filter { item -> items.none { it != item && it.contains(item) } }.distinct()
        if (candidates.size == 1) {
            return candidates.first()
        } else if (candidates.size == 2) {
            val s1 = merge(candidates[0], candidates[1])
            val s2 = merge(candidates[1], candidates[0])

            return if (s1.length < s2.length || (s1.length == s2.length && s1 < s2)) {
                s1
            } else {
                s2
            }
        }

        var result = "z".repeat(300)
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                for (k in 0 until 3) {
                    if (i == j || i == k || j == k) {
                        continue
                    }
                    val s1 = merge(merge(candidates[i], candidates[j]), candidates[k])
                    if (s1.length < result.length || (s1.length == result.length && s1 < result)) {
                        result = s1
                    }

                    val s2 = merge(candidates[k], merge(candidates[i], candidates[j]))
                    if (s2.length < result.length || (s2.length == result.length && s2 < result)) {
                        result = s2
                    }
                }
            }
        }
        return result
    }

    fun merge(a: String, b: String): String {
        val minLength = min(a.length, b.length)
        for (l in minLength downTo 1) {
            val aSub = a.substring(a.length - l)
            val bSub = b.substring(0, l)
            if (aSub == bSub) {
                return a.substring(0, a.length - l) + b
            }
        }
        return a + b
    }
}


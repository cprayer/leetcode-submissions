class Solution {
    fun minimumSwap(s1: String, s2: String): Int {
        val leftCounts = Array(2) { 0 }
        val rightCounts = Array(2) { 0 }

        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                when (s1[i]) {
                    'x' -> leftCounts[0] += 1
                    else -> leftCounts[1] += 1
                }
                when (s2[i]) {
                    'x' -> rightCounts[0] += 1
                    else -> rightCounts[1] += 1
                }
            }
        }

        if (leftCounts[0] != rightCounts[1] || leftCounts[1] != rightCounts[0] || leftCounts[0] % 2 != leftCounts[1] % 2) {
            return -1
        }
        
        return leftCounts[0] / 2 + leftCounts[1] / 2 + if (leftCounts[1] % 2 == 1) 2 else 0 
    }
}

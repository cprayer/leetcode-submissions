class Solution {
    fun beautySum(s: String): Int {
        var ans = 0

        for (i in s.indices) {
            val charCounts = IntArray(26)
            val numCounts = IntArray(s.length + 1)
            var min = 0
            var max = 0

            for (j in i until s.length) {
                val index = s[j] - 'a'
                charCounts[index]++
                val count = charCounts[index]

                if (count > 1) {
                    numCounts[count - 1]--
                }
                numCounts[count]++

                if (count > max) {
                    max = count
                }

                if (count == 1) {
                    min = 1
                } else if (count - 1 == min && numCounts[count - 1] == 0) {
                    min++
                }

                ans += max - min
            }
        }

        return ans
    }
}

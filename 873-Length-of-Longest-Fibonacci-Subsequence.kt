import java.lang.Integer.max

class Solution {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        val numSet = arr.toSet()
        var ans = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                var previous = arr[i]
                var current = arr[j]
                var next = previous + current
                var count = 0

                while (numSet.contains(next)) {
                    previous = current
                    current = next
                    next = previous + current
                    count += 1
                }
                
                if (count > 0) {
                    ans = max(ans , count + 2)
                }
            }
        }
        return ans
    }
}

class Solution {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        var remain = additionalRocks
        var answer = 0
        val items = capacity.zip(rocks) { a, b -> a - b }.sorted()
        for (item in items) {
            remain -= item
            if (remain < 0) {
                break
            }
            answer += 1
        }
        return answer
    }
}

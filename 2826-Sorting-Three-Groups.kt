class Solution {
    fun minimumOperations(nums: List<Int>): Int {
        val deque = ArrayDeque<Int>()
        var answer = 0
        for (num in nums) {
            while (deque.isNotEmpty() && deque.last() > num) {
                deque.removeLast()
                answer += 1
            }
            deque.add(num)
        }
        return answer
    }
}

class Solution {
    fun minOperations(nums: IntArray): Int {
        val queue = ArrayDeque<Int>()
        var answer = 0
        for (num in nums) {
            if (queue.isEmpty() || queue.last() <= num) {
                queue.addLast(num)
            } else {
                val items = mutableSetOf<Int>()
                while (queue.isNotEmpty() && num < queue.last()) {
                    items.add(queue.removeLast())
                }
                queue.add(num)
                answer += items.size - if(items.contains(0)) 1 else 0
            }
        }

        val items = mutableSetOf<Int>()
        while (queue.isNotEmpty()) {
            items.add(queue.removeLast())
        }
        answer += items.size - if(items.contains(0)) 1 else 0

        return answer
    }
}

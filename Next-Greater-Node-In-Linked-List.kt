/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun nextLargerNodes(head: ListNode?): IntArray {
        val answer = sortedMapOf<Int, Int>()
        val stack = mutableListOf<Pair<Int, Int>>()
        var index = 0
        var current = head

        while (current != null) {
            val currentValue = current.`val`
            while (stack.isNotEmpty()) {
                val (topIndex, topValue) = stack.last()
                if (topValue < currentValue) {
                    answer[topIndex] = currentValue
                    stack.removeLast()
                } else {
                    break
                }
            }
            stack.add(index to currentValue)
            current = current.next
            index += 1
        }

        while (stack.isNotEmpty()) {
            val (topIndex, topValue) = stack.removeLast()
            answer[topIndex] = 0
        }

        return answer.values.toIntArray()
    }
}

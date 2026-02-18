import java.lang.Integer.max
import java.lang.Integer.min

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
    fun numComponents(head: ListNode?, nums: IntArray): Int {
        val groups = IntArray(getLinkedListSize(head)) { it }

        fun find(i: Int): Int {
            if (groups[i] == i) {
                return i
            }
            return find(groups[i])
        }

        fun merge(i: Int, j: Int) {
            val minGroup = min(i, j)
            val maxGroup = max(i, j)
            groups[find(maxGroup)] = find(minGroup)
        }

        val numsSet = nums.toSet()
        var current = head
        while (current != null) {
            val currentVal = current.`val`
            val nextVal = current.next?.`val` ?: break

            if (numsSet.contains(currentVal) && numsSet.contains(nextVal)) {
                merge(currentVal, nextVal)
            }

            current = current.next
        }

        val answer = mutableSetOf<Int>()
        for (num in numsSet) {
            val element = find(num)
            answer.add(element)
        }

        return answer.size
    }

    fun getLinkedListSize(head: ListNode?): Int {
        var current = head
        var count = 0

        while(current != null) {
            count += 1
            current = current.next
        }

        return count
    }
}

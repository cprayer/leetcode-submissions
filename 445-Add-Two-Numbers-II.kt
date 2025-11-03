import java.math.BigInteger

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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val v1 = getValue(l1)
        val v2 = getValue(l2)

        println(v1 + v2)

        return getNode(v1 + v2)
    }

    fun getValue(listNode: ListNode?): BigInteger {
        var v = BigInteger.valueOf(0)
        var current = listNode
        while(current != null) {
            v = v.multiply(BigInteger.valueOf(10L))
            v = v.add(BigInteger.valueOf(current.`val`.toLong()))
            current = current.next
        }
        return v
    }

    fun getNode(v: BigInteger): ListNode {
        val vString = v.toString()
        val root = ListNode(vString.first().digitToInt())
        var current = root
        for (ch in vString.substring(1)) {
            val next = ListNode(ch.digitToInt())
            current.next = next
            current = next
        }

        return root
    }
}

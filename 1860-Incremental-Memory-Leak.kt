class Solution {
    fun memLeak(memory1: Int, memory2: Int): IntArray {
        var currentMemory1 = memory1
        var currentMemory2 = memory2
        for (i in 1..Int.MAX_VALUE) {
            when {
                currentMemory1 >= currentMemory2 -> {
                    if (currentMemory1 >= i) {
                        currentMemory1 -= i
                    } else {
                        return intArrayOf(i, currentMemory1, currentMemory2)
                    }
                }
                else -> {
                    if (currentMemory2 >= i) {
                        currentMemory2 -= i
                    } else {
                        return intArrayOf(i, currentMemory1, currentMemory2)
                    }
                }
            }
        }
        throw IllegalStateException()
    }
}

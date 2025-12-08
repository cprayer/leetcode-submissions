class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val lefts = mutableListOf<Int>()
        val rights = mutableListOf<Int>()
        val equals = mutableListOf<Int>()

        for (num in nums) {
            when {
                num < pivot -> lefts.add(num)
                num == pivot -> equals.add(num)
                num > pivot -> rights.add(num)
            }
        }
        return (lefts + equals + rights).toIntArray()
    }
}

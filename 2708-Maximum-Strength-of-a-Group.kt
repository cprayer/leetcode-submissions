class Solution {
    fun maxStrength(nums: IntArray): Long {
        val minusItems = nums.filter { it < 0 }.sorted()
        val plusItems = nums.filter { it > 0 }
        val evenMinusItems = if (minusItems.size % 2 == 1) {
            minusItems.dropLast(1)
        } else {
            minusItems
        }
        val isContainZero = nums.contains(0)

        val plusResult = plusItems.takeIf { it.isNotEmpty() }?.fold(1L) { acc, v -> acc * v }
        val minusResult = evenMinusItems.takeIf { it.isNotEmpty() }?.fold(1L) { acc, v -> acc * v }
        val result = if (plusResult != null && minusResult != null) {
            plusResult * minusResult
        } else {
            null
        }

        return listOfNotNull(
            nums.first().toLong(),
            isContainZero.takeIf { it }?.let { 0L },
            plusResult,
            minusResult,
            result,
            minusItems.takeIf { it.isNotEmpty() }?.last()?.toLong()
        ).max()
    }
}

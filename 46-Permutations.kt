class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        generate(nums, mutableListOf(), answer)
        return answer
    }

    fun generate(nums: IntArray, current: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (current.size == nums.size) {
            answer.add(current.toList())
            return
        }

        for (num in nums) {
            if (current.contains(num)) {
                continue
            }
            current.add(num)
            generate(nums, current, answer)
            current.removeLast()
        }
    }
}

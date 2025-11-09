class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val v = nums.map { it.toInt(2) }.toSet()
        for (i in 0..16) {
            if (v.contains(i)) {
                continue
            }
            return i.toString(2).padStart(nums.size, '0')
        }
        return ""
    }
}

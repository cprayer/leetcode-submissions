class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        var previous = 0
        var answer = 0
        for (devices in bank) {
            when (val current = devices.count { it == '1' }) {
                0 -> {}
                else -> {
                    answer += previous * current
                    previous = current
                }
            }
        }
        
        return answer
    }
}

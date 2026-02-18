class Solution {
    fun wonderfulSubstrings(word: String): Long {
        val currents = LongArray(1024) { 0 }
        currents[0] = 1

        var mask = 0
        var answer = 0L
        for (char in word) {
            mask = mask xor 1.shl(char - 'a')
            answer += currents[mask]
            currents[mask] = currents[mask] + 1
            for (j in 0..9) {
                answer += currents[mask xor ((1).shl(j))]
            }
        }
        return answer
    }
}

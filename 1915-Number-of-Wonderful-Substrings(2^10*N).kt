class Solution {
    fun wonderfulSubstrings(word: String): Long {
        var currents = LongArray(1024) { 0 }

        var answer = 0L
        for (i in 1..word.length) {
            val nexts = LongArray(1024) { 0 } 
            
            val char = word[i - 1]
            val selected = 1.shl(char - 'a')
            for (j in 0..1023) {
                val v = j xor selected
                nexts[v] = nexts[v] + currents[j]
            }
            nexts[selected] = nexts[selected] + 1
            
            currents = nexts
            
            var sum = currents[0]
            for (j in 0..9) {
                sum += currents[(1).shl(j)]
            }
            answer += sum
        }

        return answer
    }
}

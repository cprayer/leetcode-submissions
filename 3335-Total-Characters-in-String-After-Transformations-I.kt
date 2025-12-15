class Solution {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        var currents = LongArray(26) { 0 }
        for (element in s) {
            currents[element - 'a'] += 1
        }
        repeat(t) {
            val nexts = LongArray(26) { 0 }
            for (i in 1 until 26) {
                nexts[i] += currents[i - 1]
            }
            nexts[0] += currents[25]
            nexts[1] += currents[25]

            for (i in 0 until 26) {
                nexts[i] %= MOD
            }

            currents = nexts
        }

        return (currents.sum() % MOD).toInt()
    }

    companion object {
        val MOD = 1_000_000_007
    }
}

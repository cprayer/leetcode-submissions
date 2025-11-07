class Solution {
    fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
        val boards = Array(n) { IntArray(n) { 0 } }
        for ((index, artifact) in artifacts.withIndex()) {
            val (r1, c1, r2, c2) = artifact
            for(r in r1..r2) {
                for(c in c1..c2) {
                    boards[r][c] = index + 1
                }
            }
        }

        for ((r, c) in dig) {
            boards[r][c] = 0
        }

        return artifacts.size - boards.flatMap { row -> row.filter { it != 0 } }.toSet().size
    }
}

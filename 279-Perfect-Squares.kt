import java.lang.Integer.min

class Solution {
    fun numSquares(n: Int): Int {
        val squares = generateSquares(n)
        val answer = IntArray(n + 1) { Int.MAX_VALUE }
        answer[0] = 0
        
        for (i in 1..n) {
            for (square in squares) {
                if (square > i) {
                    break
                }
                answer[i] = min(answer[i], answer[i - square] + 1)
            }
        }
        
        return answer[n]
    }
    
    private fun generateSquares(n: Int): List<Int> {
        val squares = mutableListOf<Int>()
        var i = 1
        while (i * i <= n) {
            squares.add(i * i)
            i += 1
        }
        
        return squares
    }
}

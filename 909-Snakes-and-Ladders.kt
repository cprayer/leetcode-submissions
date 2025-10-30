import java.lang.Integer.min

class Solution {

    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size

        board.reverse()
        for (i in 0 until n) {
            if (i % 2 == 1) {
                board[i].reverse()
            }
        }

        val queue = ArrayDeque<Int>()

        var visited = Array(n * n) { false }
        var answer = 0
        queue.add(0)
        while(queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val current = queue.removeFirst()
                if (current == n * n - 1) {
                    return answer
                }
                if (visited[current]) {
                    continue
                }
                visited[current] = true

                for (next in (current + 1)..min(current + 6, n * n - 1)) {
                    val y = next / n
                    val x = next % n
                    if (board[y][x] == -1) {
                        if (!visited[next]) {
                            queue.add(next)
                        }
                    } else {
                        if (!visited[board[y][x] - 1]) {
                            queue.add(board[y][x] - 1)
                        }
                    }
                }
            }

            answer += 1
        }
        return -1
    }
}


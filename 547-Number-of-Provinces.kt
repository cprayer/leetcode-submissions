class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val visited = Array(n) { false }
        var answer = 0
        
        for (i in 0 until n) {
            if (visited[i]) {
                continue
            }
            
            val queue = ArrayDeque<Int>()
            queue.add(i)
            visited[i] = true
            
            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                for((j, isEdgeExisted) in isConnected[current].withIndex()) {
                    if (isEdgeExisted == 1 && !visited[j]) {
                        queue.add(j)
                        visited[j] = true
                    }
                }
            }
            answer += 1
        }
        
        return answer
    }
}

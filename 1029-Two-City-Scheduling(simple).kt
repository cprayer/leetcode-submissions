import java.lang.Integer.min

class Solution {

    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val n = costs.size / 2
        val sum = costs.sumOf { it[0] }
        val refund = costs.map { it[1] - it[0] }.sorted().take(n).sum()
        return sum + refund
    }
}

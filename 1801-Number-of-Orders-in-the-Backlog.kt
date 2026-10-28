class Solution {
    fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
        val buyBacklogs = PriorityQueue<Backlog> { left, right ->
            right.price - left.price
        }
        val sellBacklogs = PriorityQueue<Backlog> { left, right ->
            left.price - right.price
        }

        for ((price, amount, orderType) in orders) {
            val currentBacklogs = when (orderType) {
                0 -> buyBacklogs
                else -> sellBacklogs
            }
            val anotherBacklogs = when (orderType) {
                0 -> sellBacklogs
                else -> buyBacklogs
            }

            var currentAmount = amount
            while (currentAmount > 0 && anotherBacklogs.isNotEmpty()) {
                val anotherBacklog = anotherBacklogs.poll()
                when (orderType) {
                    0 -> {
                        if (price < anotherBacklog.price) {
                            anotherBacklogs.add(anotherBacklog)
                            break
                        }
                    }
                    else -> {
                        if (price > anotherBacklog.price) {
                            anotherBacklogs.add(anotherBacklog)
                            break
                        }
                    }
                }

                val usedAmount = min(currentAmount, anotherBacklog.amount)
                currentAmount -= usedAmount

                val remainAnotherBacklogAmount = anotherBacklog.amount - usedAmount
                if (currentAmount == 0 && remainAnotherBacklogAmount > 0) {
                    val remainAnotherBacklog = anotherBacklog.copy(amount = remainAnotherBacklogAmount)
                    anotherBacklogs.add(remainAnotherBacklog)
                }
            }

            if (currentAmount > 0) {
                val currentBacklog = Backlog(price, currentAmount)
                currentBacklogs.add(currentBacklog)
            }
        }

        var ans = 0
        for (backlogs in listOf(buyBacklogs, sellBacklogs)) {
            for ((_, amount) in backlogs) {
                ans = (ans + amount) % MOD
            }
        }

        return ans
    }

    companion object {
        const val MOD = 1_000_000_007
    }
}

data class Backlog(
    val price: Int,
    val amount: Int,
)

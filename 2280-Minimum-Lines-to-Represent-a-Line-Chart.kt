class Solution {
    fun minimumLines(stockPrices: Array<IntArray>): Int {
        if (stockPrices.size == 1) {
            return 0
        }

        stockPrices.sortWith { o1, o2 ->
            o1[0] - o2[0]
        }

        var answer = 1
        var standardDayDiff = stockPrices[1][0] - stockPrices[0][0]
        var standardPriceDiff = stockPrices[1][1] - stockPrices[0][1]

        for (i in 1 until stockPrices.size) {
            val dayDiff = stockPrices[i][0] - stockPrices[i - 1][0]
            val priceDiff = stockPrices[i][1] - stockPrices[i - 1][1]

            if (standardDayDiff.toLong() * priceDiff != standardPriceDiff.toLong() * dayDiff) {
                answer += 1
                standardDayDiff = dayDiff
                standardPriceDiff = priceDiff
            }
        }

        return answer
    }
}

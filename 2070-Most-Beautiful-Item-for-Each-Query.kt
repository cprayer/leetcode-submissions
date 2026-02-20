import java.lang.Integer.max

class Solution {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        val beautyByPrice = sortedMapOf<Int, Int>()
        for ((price, beauty) in items) {
            if (beautyByPrice.getOrDefault(price, 0) < beauty) {
                beautyByPrice[price] = beauty
            }
        }

        val answerByQuery = mutableMapOf<Int, Int>()
        val prices = beautyByPrice.keys.toList()
        var priceIndex = 0
        var currentMax = 0
        
        for (query in queries.sorted()) {
            while (priceIndex < prices.size && prices[priceIndex] <= query) {
                currentMax = max(currentMax, beautyByPrice.getValue(prices[priceIndex]))
                priceIndex += 1
            }
            answerByQuery[query] = currentMax
        }

        return queries.map { answerByQuery.getOrDefault(it, 0) }.toIntArray()
    }
}

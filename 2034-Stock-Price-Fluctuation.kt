class StockPrice() {

    val priceByTimestamp = sortedMapOf<Int, Int>()
    val prices = sortedMapOf<Int, Int>()

    fun update(timestamp: Int, price: Int) {
      if (priceByTimestamp.containsKey(timestamp)) {
        val previousPrice = priceByTimestamp.getValue(timestamp)
        prices[previousPrice] = prices.getOrDefault(previousPrice, 0) - 1
        if (prices.getOrDefault(previousPrice, 0) == 0) {
          prices.remove(previousPrice)
        }
      }
      priceByTimestamp[timestamp] = price
      prices[price] = prices.getOrDefault(price, 0) + 1
    }

    fun current(): Int {
      return priceByTimestamp.getValue(priceByTimestamp.lastKey())
    }

    fun maximum(): Int {
      return prices.lastKey()
    }

    fun minimum(): Int {
      return prices.firstKey()
    }
}

class UndergroundSystem() {
    private val counts = mutableMapOf<Pair<String, String>, Int>()
    private val sums = mutableMapOf<Pair<String, String>, Int>()
    private val checkIns = mutableMapOf<Int, CheckIn>()
    
    fun checkIn(id: Int, stationName: String, t: Int) {
        checkIns[id] = CheckIn(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        checkIns.remove(id)?.let {
            val target = it.startStation to stationName
            counts[target] = counts.getOrDefault(target, 0) + 1
            sums[target] = sums.getOrDefault(target, 0) + (t - it.startTime)
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val target = startStation to endStation
        return sums.getValue(target) / counts.getValue(target).toDouble()
    }

    data class CheckIn(
        val startStation: String,
        val startTime: Int
    )
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

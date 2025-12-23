class Solution {
    fun maxValue(n: String, x: Int): String {
        return when {
            n[0] == '-' -> {
                val maximum = getMaximum(n.substring(1), x, false)
                return "-$maximum"
            }
            else -> getMaximum(n, x, true)
        }
    }

    private fun getMaximum(n: String, x: Int, greaterThan: Boolean): String {
        val index = n.indexOfFirst {
            if (greaterThan) {
                it.digitToInt() < x
            } else {
                it.digitToInt() > x
            }
        } 
        if (index == -1) {
            return n + x
        }
        return n.substring(0, index) + x + n.substring(index)
    }
}

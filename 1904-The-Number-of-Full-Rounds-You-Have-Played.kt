import java.lang.Integer.max

class Solution {
    fun numberOfRounds(loginTime: String, logoutTime: String): Int {
        val startTime = convert(loginTime)
        var endTime = convert(logoutTime)
        if (startTime > endTime) {
            endTime += 60 * 24
        }

        return max((endTime / 15) - (startTime + 15 - 1) / 15, 0)
    }

    private fun convert(time: String): Int {
        val (hh, mm) = time.split(":")
        return hh.toInt() * 60 + mm.toInt()
    }
}

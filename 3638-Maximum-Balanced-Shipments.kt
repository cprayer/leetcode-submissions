class Solution {
    fun maxBalancedShipments(weight: IntArray): Int {
        var current = Int.MIN_VALUE
        var answer = 0
        for (parcel in weight) {
            if (current <= parcel) {
                current = parcel
            } else {
                answer += 1
                current = Int.MIN_VALUE
            }
        }
        return answer
    }
}

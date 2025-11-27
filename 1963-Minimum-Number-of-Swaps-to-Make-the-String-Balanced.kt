class Solution {
    fun minSwaps(s: String): Int {
        var count = 0
        var answer = 0
        
        for (ch in s) {
            if (ch == '[') {
                count += 1
            } else {
                count -= 1
            }
            
            if (count < 0) {
                count = 1
                answer += 1
            }
        }
        
        return answer
    }
}

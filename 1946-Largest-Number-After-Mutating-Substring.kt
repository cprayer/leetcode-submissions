class Solution {
    fun maximumNumber(num: String, change: IntArray): String {
        var index = 0
        val answer = StringBuilder()
        while(index < num.length) {
            val v = num[index].digitToInt()
            if (v < change[v]) {
                break
            }
            answer.append(v)
            index += 1
        }
        
        while(index < num.length) {
            val v = num[index].digitToInt()
            if (v <= change[v]) {
                answer.append(change[v])
            } else {
                break
            }
            index += 1
        }
        
        while(index < num.length) {
            answer.append(num[index])
            index += 1
        }
        
        return answer.toString()
    }
}

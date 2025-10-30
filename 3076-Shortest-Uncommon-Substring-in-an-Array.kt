class Solution {
    fun shortestSubstrings(arr: Array<String>): Array<String> {
        val answer = Array(arr.size) { "" }
        for (l in arr.indices) {
            val str = arr[l]
            for (i in str.indices) {
                for (j in (i + 1)..str.length) {
                    val substr = str.substring(i, j)
                    var isUncommon = true
                    for (k in arr.indices) {
                        if (k == l) {
                            continue
                        }
                        if (arr[k].contains(substr)) {
                            isUncommon = false
                            break
                        }
                    }

                    if (isUncommon) {
                        if(answer[l] == "" || answer[l].length > substr.length || (answer[l].length == substr.length && answer[l] > substr)) {
                            answer[l] = substr
                        }
                    }
                }
            }
        }
        return answer
    }
}

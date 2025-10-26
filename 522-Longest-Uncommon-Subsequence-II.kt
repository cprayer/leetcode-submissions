import java.lang.Integer.max

class Solution {
    fun findLUSlength(strs: Array<String>): Int {
        var answer = -1
        for (i in strs.indices) {
            var isUncommon = true
            for (j in strs.indices) {
                if (i == j) {
                    continue
                }
                var iIndex = 0
                for (char in strs[j]) {
                    if (iIndex < strs[i].length && strs[i][iIndex] == char) {
                        iIndex += 1
                    }
                }
                if (iIndex == strs[i].length) {
                    isUncommon = false
                }
            }
            if (isUncommon) {
                answer = max(answer, strs[i].length)
            }
        }
        return answer
    }
}

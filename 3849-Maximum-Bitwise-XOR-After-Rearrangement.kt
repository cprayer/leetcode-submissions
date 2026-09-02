class Solution {
    fun maximumXor(s: String, t: String): String {
        var oneCount = t.count { it == '1' }
        var zeroCount = t.count { it == '0' }

        var ans = mutableListOf<Char>()
        for (ch in s) {
            if (ch == '1') {
                if (zeroCount > 0) {
                    ans += '1'
                    zeroCount -= 1
                } else {
                    ans += '0'
                    oneCount -= 1
                }
            } else {
                if (oneCount > 0) {
                    ans += '1'
                    oneCount -= 1
                } else {
                    ans += '0'
                    zeroCount -= 1
                }
            }
        }

        return ans.joinToString("")
    }
}

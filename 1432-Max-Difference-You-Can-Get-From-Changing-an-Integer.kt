class Solution {
    fun maxDiff(num: Int): Int {
        if (num < 10) {
            return 8
        }

        val numString = num.toString()
        val a = numString.let {
          val target = numString.firstOrNull { it != '9' } ?: '9'
            numString.replace(target, '9')
        }

        val b = numString.let {
            val firstChar = numString.first()
            if (firstChar == '1') {
                val target = numString.firstOrNull { it != '1' && it != '0' } ?: return@let numString
                numString.replace(target, '0')
            } else {
                numString.replace(firstChar, '1')
            }
        }

        return a.toInt() - b.toInt()
    }
}

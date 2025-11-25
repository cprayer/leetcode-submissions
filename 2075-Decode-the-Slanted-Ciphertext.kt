class Solution {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        val lineSize = encodedText.length / rows
        val lines = mutableListOf<String>()
        for (i in 0 until rows) {
            val start = i * lineSize
            lines.add(encodedText.substring(start, start + lineSize))
        }

        val stringBuilder = StringBuilder()
        for (i in 0 until lineSize) {
            for (j in 0 until rows) {
                if (i + j >= lineSize) {
                    break
                }
                stringBuilder.append(lines[j][i + j])
            }
        }
        return stringBuilder.toString().trimEnd()
    }
}

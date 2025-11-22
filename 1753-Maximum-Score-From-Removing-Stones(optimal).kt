class Solution {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        val items = listOf(a, b, c).sorted()
        if (items[0] + items[1] <= items[2]) {
            return (items[0] + items[1])
        } else {
            return (items[0] + items[1] + items[2]) / 2
        }
    }
}

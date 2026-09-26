class Solution {
    fun removeDuplicateLetters(s: String): String {
        val counts = s.groupingBy { it }.eachCount().toMutableMap()
        val stacks = ArrayDeque<Char>()
        val sets = mutableSetOf<Char>()

        for (ch in s) {
            if (!sets.contains(ch)) {
                while (stacks.isNotEmpty() && stacks.last() > ch && counts.getOrDefault(stacks.last(), 0) >= 1) {
                    val last = stacks.removeLast()
                    sets.remove(last)
                }
                stacks.add(ch)
                sets.add(ch)
            }
            counts[ch] = counts.getOrDefault(ch, 0) - 1
        }

        return stacks.joinToString("")
    }
}

class Solution {
    fun dividePlayers(skill: IntArray): Long {
        skill.sort()

        val sum = (skill.first() + skill.last())

        var answer = 0L
        for (i in 0 until skill.size / 2) {
            val left = skill[i]
            val right = skill[skill.size - 1 - i]
            if (left + right != sum) {
                return -1
            }
            answer += (left * right)
        }

        return answer
    }
}

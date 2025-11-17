class Solution {
    fun validTicTacToe(board: Array<String>): Boolean {
        val validStates = mutableSetOf<List<Int>>()
        val currentState = IntArray(9) { 0 }

        calculateAllValidStates(validStates, currentState, 0)
        println(validStates.size)
        val state = board.flatMap { row ->
            row.map {
                when (it) {
                    'X' -> 1
                    'O' -> 2
                    else -> 0
                }
            }
        }

        return validStates.contains(state)
    }

    fun calculateAllValidStates(validStates: MutableSet<List<Int>>, currentState: IntArray, turn: Int) {
        val currentStateList = currentState.toList()
        if (validStates.contains(currentStateList)) {
            return
        } else {
            validStates.add(currentStateList)
        }
        if (currentState.count { it != 0 } == 9) {
            return
        }
        for (i in 0 until 3) {
            if (currentState[i * 3] != 0 && currentState[i * 3] == currentState[i * 3 + 1] && currentState[i * 3] == currentState[i * 3 + 2]) {
                return
            }
            if (currentState[i] != 0 && currentState[i] == currentState[i + 3] && currentState[i] == currentState[i + 6]) {
                return
            }
        }
        if (currentState[0] != 0 && currentState[0] == currentState[4] && currentState[0] == currentState[8]) {
            return
        }
        if (currentState[2] != 0 && currentState[2] == currentState[4] && currentState[2] == currentState[6]) {
            return
        }

        for (i in 0 until 9) {
            if (currentState[i] != 0) {
                continue
            }
            currentState[i] = when (turn % 2) {
                0 -> 1
                else -> 2
            }
            calculateAllValidStates(validStates, currentState, turn + 1)
            currentState[i] = 0
        }
    }
}

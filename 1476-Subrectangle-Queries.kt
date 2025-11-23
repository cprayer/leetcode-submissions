class SubrectangleQueries(rectangle: Array<IntArray>) {

    val originRectangle = rectangle
    val updateQueries = mutableListOf<UpdateQuery>()

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        updateQueries.add(UpdateQuery(row1, col1, row2, col2, newValue))
    }

    fun getValue(row: Int, col: Int): Int {
        for ((row1, col1, row2, col2, newValue) in updateQueries.asReversed()) {
            if (row in row1..row2 && col in col1..col2) {
                return newValue
            }
        }
        return originRectangle[row][col]
    }

    data class UpdateQuery(
        val row1: Int,
        val col1: Int,
        val row2: Int,
        val col2: Int,
        val newValue: Int,
    )

}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * var obj = SubrectangleQueries(rectangle)
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue)
 * var param_2 = obj.getValue(row,col)
 */

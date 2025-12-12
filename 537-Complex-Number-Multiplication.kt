class Solution {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val (real1, imaginary1) = num1.split("+")
        val real1Num = real1.toInt()
        val imaginary1Num = imaginary1.dropLast(1).toInt()

        val (real2, imaginary2) = num2.split("+")
        val real2Num = real2.toInt()
        val imaginary2Num = imaginary2.dropLast(1).toInt()

        val realNum = (real1Num * real2Num - imaginary1Num * imaginary2Num)
        val imaginaryNum = (real1Num * imaginary2Num + real2Num * imaginary1Num)

        return "$realNum+${imaginaryNum}i"
    }

}

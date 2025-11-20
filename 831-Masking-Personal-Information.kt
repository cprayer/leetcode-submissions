class Solution {
    fun maskPII(s: String): String {
        return when (s.contains('@')) {
            true -> maskEmail(s)
            false -> maskPhoneNumber(s)
        }
    }

    fun maskEmail(s: String): String {
        val (name, domain) = s.split('@')
        val lowerCaseName = name.lowercase()
        return lowerCaseName.first() + "*".repeat(5) + lowerCaseName.last() + "@" + domain.lowercase()
    }

    fun maskPhoneNumber(s: String): String {
        val digits = s.filter { it.isDigit() }
        val countryCodeString = when (val length = digits.length) {
            10 -> ""
            else -> "+" + "*".repeat(length - 10) + "-"
        }
        return countryCodeString + "***-***-" + digits.takeLast(4)
    }
}

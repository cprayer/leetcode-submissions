class Solution {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var current = mass.toLong()
        for (asteroid in asteroids) {
            if (current < asteroid) {
                return false
            }
            current += asteroid
        }
        return true
    }
}
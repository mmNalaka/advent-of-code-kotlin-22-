

fun main() {
    // a to Z
    val charVal = mapOf(
        'a' to 1,
        'b' to 2,
        'c' to 3,
        'd' to 4,
        'e' to 5,
        'f' to 6,
        'g' to 7,
        'h' to 8,
        'i' to 9,
        'j' to 10,
        'k' to 11,
        'l' to 12,
        'm' to 13,
        'n' to 14,
        'o' to 15,
        'p' to 16,
        'q' to 17,
        'r' to 18,
        's' to 19,
        't' to 20,
        'u' to 21,
        'v' to 22,
        'w' to 23,
        'x' to 24,
        'y' to 25,
        'z' to 26,

        'A' to 27,
        'B' to 28,
        'C' to 29,
        'D' to 30,
        'E' to 31,
        'F' to 32,
        'G' to 33,
        'H' to 34,
        'I' to 35,
        'J' to 36,
        'K' to 37,
        'L' to 38,
        'M' to 39,
        'N' to 40,
        'O' to 41,
        'P' to 42,
        'Q' to 43,
        'R' to 44,
        'S' to 45,
        'T' to 46,
        'U' to 47,
        'V' to 48,
        'W' to 49,
        'X' to 50,
        'Y' to 51,
        'Z' to 52,
    )

    // Part 1
    fun part1(input: String): Int {
        val data = input.lines()

        //Split a string in to two same length strings
        fun splitString(input: String): Pair<String, String> {
            val half = input.length / 2
            return input.substring(0, half) to input.substring(half)
        }

        fun findDuplicateChar(first: String, second: String): Char? {
            return first.firstOrNull { it in second }
        }

        return data.sumOf { rucksack: String ->
            val (first, second) = splitString(rucksack)
            val duplicate = findDuplicateChar(first, second)
            if (duplicate != null) {
              charVal.getValue(duplicate)
            } else {
                0
            }
        }
    }


    fun part2(input: String): Int {
        val data = input.lines()
        val groups = data.chunked(3)

        fun findCommonChar(first: String, second: String, third: String): Char? {
            return first.firstOrNull { it in second && it in third }
        }

        return groups.sumOf { group ->
            val (first, second, third) = group
            val common = findCommonChar(first, second, third)
            if (common != null) {
                charVal.getValue(common)
            } else {
                0
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println("Part 1")
    part1(input).println()
    println("Part 2")
    part2(input).println()
}

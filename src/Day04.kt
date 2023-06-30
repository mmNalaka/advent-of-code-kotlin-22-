fun main() {

    fun inRage(first: Pair<Int, Int>, second: Pair<Int, Int>): Int {
        return if (first.first <= second.first && first.second >= second.second ||
            second.first <= first.first && second.second >= first.second
        ) {
            1
        } else {
            0
        }
    }

    fun isOverlapped (first: Pair<Int, Int>, second: Pair<Int, Int>): Boolean {
        return first.first <= second.first && first.second >= second.first ||
                second.first <= first.first && second.second >= first.first
    }

    // Part 1
    fun part1(input: String): Int {
        val data = input.lines()

        return data.sumOf { pair ->
            val (first, second) = pair.split(",")
            val firstRange: Pair<Int, Int> = first.split("-").first().toInt() to first.split("-").last().toInt()
            val secondRange: Pair<Int, Int> = second.split("-").first().toInt() to second.split("-").last().toInt()

            inRage(firstRange, secondRange)
        }
    }


    fun part2(input: String): Int {
        val data = input.lines()
        var count = 0

        data.forEach{ pair ->
            val (first, second) = pair.split(",")
            val firstRange: Pair<Int, Int> = first.split("-").first().toInt() to first.split("-").last().toInt()
            val secondRange: Pair<Int, Int> = second.split("-").first().toInt() to second.split("-").last().toInt()

            if (isOverlapped(firstRange, secondRange)) {
                count++
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    part2(testInput).println()
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println("Part 1")
    part1(input).println()
    println("Part 2")
    part2(input).println()
}

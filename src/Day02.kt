fun main() {
    // Part 1
    fun part1(input: String): Int {
        val data = input.lines()


        fun shapeScore(you: Char): Int {
            return when (you) {
                'X' -> 1
                'Y' -> 2
                'Z' -> 3
                else -> 0
            }
        }

        fun roundScore(opponent: Char, you: Char): Int {
            return when (opponent to you) {
                'A' to 'Z', 'B' to 'X', 'C' to 'Y' -> 0
                'A' to 'X', 'B' to 'Y', 'C' to 'Z' -> 3
                'A' to 'Y', 'B' to 'Z', 'C' to 'X' -> 6
                else -> -1
            }
        }

        return data.sumOf { round ->
            val (opponent, _, you) = round.toList()
//            println("$opponent vs $you")
//            shapeScore(you).println()
//            roundScore(opponent, you).println()
//            println("-----------------")
            shapeScore(you) + roundScore(opponent, you)
        }
    }


    fun part2(input: String): Int {
        val data = input.lines()

        fun roundEndScore(opponent: Char, you: Char): Int {
            return when (opponent to you) {
                'A' to 'X' -> 0 + 3
                'A' to 'Y' -> 3  + 1
                'A' to 'Z' -> 6  + 2

                'B' to 'X' -> 0  + 1
                'B' to 'Y' -> 3  + 2
                'B' to 'Z' -> 6  + 3

                'C' to 'X' -> 0  + 2
                'C' to 'Y' -> 3  + 3
                'C' to 'Z' -> 6  + 1
                else -> -1
            }
        }

        return data.sumOf { round ->
            val (opponent, _, you) = round.toList()
//            println("$opponent vs $you")
//            roundEndScore(opponent, you).println()
//            println("-----------------")
            roundEndScore(opponent, you)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println("Part 1")
    part1(input).println()
    println("Part 2")
    part2(input).println()
}

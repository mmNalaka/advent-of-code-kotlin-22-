fun main() {
    fun part1(input: String): Int {
        val data = input.split("\n\n").map { elf: String ->
            elf.lines().map { it.toInt() }
        }

        return data.maxOf { it.sum() }
    }


    fun part2(input: String): Int {
        val data = input.split("\n\n").map { elf: String ->
            elf.lines().map { it.toInt() }
        }

       return data.map { it.sum() }.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println("Part 1")
    part1(input).println()
    println("Part 2")
    part2(input).println()
}

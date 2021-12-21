package day07

import Puzzle
import kotlin.math.abs

object Day07Part2 : Puzzle {

    override fun result(input: String): String {
        val values = input.lines().first().split(',').map(String::toInt)
        val min = values.minOrNull()!!
        val max = values.maxOrNull()!!

        return IntRange(min, max)
            .minOf { fuelForValues(values, it) }
            .toString()
    }

    private fun fuelForValues(values: List<Int>, destinationValue: Int) =
        values
            .map { abs(destinationValue - it) }
            .sumOf { fuelForChanges(it) }

    private fun fuelForChanges(changes: Int) =
        generateSequence(1) { it + 1 }
            .take(changes)
            .sum()
            .toLong()
}
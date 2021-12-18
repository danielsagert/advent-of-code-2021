package day07

import Puzzle
import kotlin.math.abs

object Day07Part1 : Puzzle {

    override fun result(input: String): String {
        val values = input.lines().first().split(',').map(String::toInt)
        val min = values.minOrNull()!!
        val max = values.maxOrNull()!!

        return IntRange(min, max)
            .minOf { calculateFuel(values, it) }
            .toString()
    }

    private fun calculateFuel(values: List<Int>, destinationValue: Int): Long =
        values.sumOf { abs(destinationValue - it).toLong() }
}
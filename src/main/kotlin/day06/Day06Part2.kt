package day06

import Puzzle

object Day06Part2 : Puzzle {

    override fun result(input: String): String {
        var timers = initialTimers(input)
        IntRange(1, 256).forEach { _ -> timers = addOneDay(timers) }
        return timers.values.sum().toString()
    }

    private fun initialTimers(input: String) = input.split(',')
        .map(String::toInt)
        .groupingBy { it }
        .eachCount()
        .mapValues { it.value.toLong() }

    private fun addOneDay(timers: Map<Int, Long>): Map<Int, Long> {
        return timers.map {
            if (it.key == 0) {
                listOf(6 to it.value, 8 to it.value)
            } else {
                listOf(it.key - 1 to it.value)
            }
        }.flatten()
            .groupBy { it.first }
            .values
            .associate { it.reduce { acc, pair -> acc.first to acc.second + pair.second } }
    }
}

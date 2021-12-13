package day06

import Puzzle

object Day06Part1 : Puzzle {
    override fun result(input: String): Int {
        var counts = input.split(',').map(String::toInt)
        IntRange(1, 80).forEach { counts = addOneDay(counts) }
        return counts.size
    }

    private fun addOneDay(counts: List<Int>): List<Int> {
        val (old, new) = counts.map {
            if (it == 0) {
                6 to 8
            } else {
                it - 1 to null
            }
        }.unzip()
        return old + new.filterNotNull()
    }
}

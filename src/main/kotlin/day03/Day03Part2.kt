package day03

import Puzzle

object Day03Part2 : Puzzle {
    override fun result(input: String): Int {
        val lines = input.lines().filterNot(String::isNullOrEmpty)
        val oxygenGeneratorRating = filterByMostCommon(lines, 0).toInt(2)
        val co2ScrubberRating = filterByLessCommon(lines, 0).toInt(2)
        return oxygenGeneratorRating * co2ScrubberRating
    }

    private fun filterByMostCommon(lines: List<String>, index: Int): String {
        val mostCommon = mostCommon(lines, index)
        val filtered = lines.filter { it[index].digitToInt() == mostCommon }
        return if (filtered.size == 1) {
            return filtered.first()
        } else {
            filterByMostCommon(filtered, index + 1)
        }
    }

    private fun filterByLessCommon(lines: List<String>, index: Int): String {
        val lessCommon = lessCommon(lines, index)
        val filtered = lines.filter { it[index].digitToInt() == lessCommon }
        return if (filtered.size == 1) {
            return filtered.first()
        } else {
            filterByLessCommon(filtered, index + 1)
        }
    }

    private fun mostCommon(lines: List<String>, index: Int): Int {
        val halfItemCount = lines.size / 2.0
        val sum = lines.sumOf { it.toCharArray()[index].toString().toInt() }
        return if (sum >= halfItemCount) 1 else 0
    }

    private fun lessCommon(lines: List<String>, index: Int): Int {
        val halfItemCount = lines.size / 2.0
        val sum = lines.sumOf { it.toCharArray()[index].toString().toInt() }
        return if (sum >= halfItemCount) 0 else 1
    }
}

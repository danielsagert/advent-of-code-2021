package day08

import Puzzle

object Day08Part1 : Puzzle {
    private val uniqueNumberSegments = mapOf(
        1 to 2,
        4 to 4,
        7 to 3,
        8 to 7
    )

    override fun result(input: String): String {
        return input.lines()
            .filterNot(String::isNullOrEmpty)
            .map { it.split('|')[1] }
            .map { it.trim().split(' ') }
            .flatten()
            .map(String::length)
            .count { uniqueNumberSegments.containsValue(it) }
            .toString()
    }
}
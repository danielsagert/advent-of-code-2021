package day01

import Puzzle

object Day01Part1 : Puzzle {
    override fun result(input: String): String {
        return input.lineSequence()
            .mapNotNull(String::toIntOrNull)
            .windowed(2)
            .count { it.last() > it.first() }
            .toString()
    }
}

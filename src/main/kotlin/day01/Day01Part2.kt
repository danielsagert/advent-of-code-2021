package day01

import Puzzle

object Day01Part2 : Puzzle {
    override fun result(input: String): Int {
        return input.lineSequence()
            .mapNotNull(String::toIntOrNull)
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count { it.last() > it.first() }
    }
}

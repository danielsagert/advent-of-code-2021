package day01

import common.FileReader

object Part2 {
    fun result(input: String): Int {
        return input.lineSequence()
            .mapNotNull(String::toIntOrNull)
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count() { it.last() > it.first() }
    }
}

fun main() {
    val input = FileReader.content("/day01/input.txt")
    println(Part2.result(input))
}

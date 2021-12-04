package day01

import FileReader

object Part1 {
    fun result(input: String): Int {
        return input.lineSequence()
            .mapNotNull(String::toIntOrNull)
            .windowed(2)
            .count() { it.last() > it.first() }
    }
}

fun main() {
    val input = FileReader.content("/day01/input.txt")
    println(Part1.result(input))
}

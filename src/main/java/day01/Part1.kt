package day01

import common.FileReader

fun result(input: String): Int {
    return input.lines()
        .mapNotNull(String::toIntOrNull)
        .windowed(2)
        .count() { it.last() > it.first() }
}

fun main() {
    val input = FileReader.content("/day01/test-input.txt")
    println(result(input))
}

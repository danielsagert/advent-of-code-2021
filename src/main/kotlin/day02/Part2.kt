package day02

import common.FileReader

object Part2 {
    data class Position(val horizontal: Int, val depth: Int, val aim: Int)

    fun result(input: String): Int {
        val position = input.lineSequence()
            .filterNot(String::isNullOrEmpty)
            .map { it.split(" ") }
            .map { Pair(it.first(), it.last().toInt()) }
            .fold(Position(0, 0, 0)) { position, command ->
                val value = command.second
                val (horizontal, depth, aim) = position
                when (command.first) {
                    "forward" -> Position(horizontal + value, depth + (aim * value), aim)
                    "down" -> Position(horizontal, depth, aim + value)
                    "up" -> Position(horizontal, depth, aim - value)
                    else -> position
                }
            }
        return position.horizontal * position.depth
    }
}

fun main() {
    val input = FileReader.content("/day02/input.txt")
    println(Part2.result(input))
}
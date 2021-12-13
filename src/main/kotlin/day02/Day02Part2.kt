package day02

import Puzzle

object Day02Part2 : Puzzle {
    data class Position(val horizontal: Int, val depth: Int, val aim: Int)

    override fun result(input: String): String {
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
        return (position.horizontal * position.depth).toString()
    }
}

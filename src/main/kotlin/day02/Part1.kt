package day02

import common.FileReader

object Part1 {
    fun result(input: String): Int {
        val commandSums = input.lineSequence()
            .filterNot(String::isNullOrEmpty)
            .map { it.split(" ") }
            .map { Pair(it.first(), it.last().toInt()) }
            .groupBy({ it.first }, { it.second })
            .mapValues { it.value.sum() }
        val horizontal = commandSums.getOrDefault("forward", 0)
        val depth = commandSums.getOrDefault("down", 0)
            .minus(commandSums.getOrDefault("up", 0))
        return horizontal.times(depth)
    }
}

fun main() {
    val input = FileReader.content("/day02/input.txt")
    println(Part1.result(input))
}
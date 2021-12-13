package day05

import Puzzle

object Day05Part1 : Puzzle {
    data class Position(val x: Int, val y: Int)

    override fun result(input: String): String {
        val lines = input.lines()
            .filter(String::isNotBlank)
            .map(::toPositionPair)
            .filter(::isVerticalOrHorizontal)
        val allPositions = lines.flatMap { it.toList() }
        val maxX = allPositions.maxOfOrNull(Position::x)?.let { it + 1 } ?: 0
        val maxY = allPositions.maxOfOrNull(Position::y)?.let { it + 1 } ?: 0
        val diagram = Array(maxY) { IntArray(maxX) { 0 } }

        for (line in lines) {
            val fromX = minOf(line.first.x, line.second.x)
            val toX = maxOf(line.first.x, line.second.x)
            val fromY = minOf(line.first.y, line.second.y)
            val toY = maxOf(line.first.y, line.second.y)

            for (x in fromX..toX) {
                for (y in fromY..toY) {
                    diagram[y][x] = diagram[y][x] + 1
                }
            }
        }

        return diagram.flatMap { it.asIterable() }.count { it > 1 }.toString()
    }

    private fun toPositionPair(line: String): Pair<Position, Position> {
        val coordinates = line.split("->")
        return Pair(toPosition(coordinates.first()), toPosition(coordinates.last()))
    }

    private fun toPosition(coordinates: String): Position {
        val points = coordinates.split(",")
        val x = points.first().trim().toInt()
        val y = points.last().trim().toInt()
        return Position(x, y)
    }

    private fun isVerticalOrHorizontal(line: Pair<Position, Position>) =
        line.first.x == line.second.x || line.first.y == line.second.y
}

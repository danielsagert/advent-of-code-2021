package day05

import Puzzle

object Day05Part2 : Puzzle {
    data class Position(val x: Int, val y: Int)

    override fun result(input: String): String {
        val lines = input.lines()
            .filter(String::isNotBlank)
            .map(::toPositionPair)
        val allPositions = lines.flatMap { it.toList() }
        val maxX = allPositions.maxOfOrNull(Position::x)?.let { it + 1 } ?: 0
        val maxY = allPositions.maxOfOrNull(Position::y)?.let { it + 1 } ?: 0
        val diagram = Array(maxY) { IntArray(maxX) { 0 } }

        for (line in lines) {
            val xSteps = toSteps(line.first.x, line.second.x)
            val ySteps = toSteps(line.first.y, line.second.y)

            val points = if (xSteps.size == 1) {
                // vertical
                val x = xSteps.first()
                ySteps.map { Pair(x, it) }
            } else if (ySteps.size == 1) {
                // horizontal
                val y = ySteps.first()
                xSteps.map { Pair(it, y) }
            } else {
                //diagonal
                xSteps.zip(ySteps)
            }

            for (point in points) {
                val x = point.first
                val y = point.second
                diagram[y][x] = diagram[y][x] + 1
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

    private fun toSteps(from: Int, to: Int) =
        if (from <= to) {
            (from..to).toList()
        } else {
            (from downTo to).toList()
        }
}

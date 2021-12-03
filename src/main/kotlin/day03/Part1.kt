package day03

import common.FileReader

object Part1 {
    fun result(input: String): Int {
        val lines = input.lines().filterNot(String::isNullOrEmpty)
        val halfItemCount = lines.size / 2
        val valueLength = lines.first().length
        val gammaRate = lines
            .fold(IntArray(valueLength) { 0 }) { sums, line ->
                for ((index, digit) in line.toCharArray().withIndex()) {
                    sums[index] = sums[index] + digit.toString().toInt()
                }
                sums
            }
            .map { if (it > halfItemCount) 1 else 0 }
            .joinToString(separator = "")
            .toInt(2)
        val epsilonRate = gammaRate.xor("1".repeat(valueLength).toInt(2))
        return gammaRate * epsilonRate
    }
}

fun main() {
    val input = FileReader.content("/day03/input.txt")
    println(Part1.result(input))
}

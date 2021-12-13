import day06.Day06Part1

fun content(filePath: String) = object {}.javaClass.getResource(filePath)?.readText().orEmpty()

fun main() {
    val input = content("/day06/input.txt")
    println(Day06Part1.result(input))
}
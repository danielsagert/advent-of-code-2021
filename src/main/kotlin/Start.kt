import day06.Day06Part2
import kotlin.system.measureTimeMillis

fun content(filePath: String) = object {}.javaClass.getResource(filePath)?.readText().orEmpty()

fun main() {
    val input = content("/day06/input.txt")
    val duration = measureTimeMillis {
        println("Result: ${Day06Part2.result(input)}")
    }
    println("Duration: $duration ms")
}
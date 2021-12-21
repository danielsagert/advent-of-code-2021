import day07.Day07Part2
import kotlin.system.measureTimeMillis

fun content(filePath: String) = object {}.javaClass.getResource(filePath)?.readText().orEmpty()

fun main() {
    val input = content("/day07/input.txt")
    val duration = measureTimeMillis {
        println("Result: ${Day07Part2.result(input)}")
    }
    println("Duration: $duration ms")
}
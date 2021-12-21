import day08.Day08Part1
import kotlin.system.measureTimeMillis

fun content(filePath: String) = object {}.javaClass.getResource(filePath)?.readText().orEmpty()

fun main() {
    val input = content("/day08/input.txt")
    val duration = measureTimeMillis {
        println("Result: ${Day08Part1.result(input)}")
    }
    println("Duration: $duration ms")
}
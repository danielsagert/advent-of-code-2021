package day04

object Part2 {
    fun result(input: String): Int {
        val lines = input.lines().filter { it.isNotBlank() }
        val numbers = extractNumbers(lines)
        val boards = extractBoards(lines)
        val combosOfAllBoards = combos(boards)
        val finalizedBoards = mutableListOf<Int>()
        var finalizingNumbers = emptyList<Int>()

        for (i in 5..numbers.size + 1) {
            val activeNumbers = numbers.subList(0, i - 1)

            for ((boardIndex, comboOfSingleBoard) in combosOfAllBoards.withIndex()) {
                if (finalizedBoards.contains(boardIndex)) continue

                for (combo in comboOfSingleBoard) {
                    if (activeNumbers.containsAll(combo)) {
                        finalizedBoards.add(boardIndex)
                        finalizingNumbers = activeNumbers
                        break
                    }
                }
            }
        }

        val lastBoard = boards[finalizedBoards.last()]
        val unmarkedSum = sumOfUnmarked(lastBoard, finalizingNumbers)
        val lastNumber = finalizingNumbers.last()
        return unmarkedSum * lastNumber
    }

    private fun extractNumbers(lines: List<String>) = lines[0]
        .split(",")
        .map { it.toInt() }

    private fun extractBoards(lines: List<String>) = lines
        .drop(1)
        .chunked(5)
        .map { boardLines ->
            List(5) { i ->
                boardLines[i].trim().split("\\s+".toRegex()).map { it.toInt() }.toList()
            }
        }

    private fun combos(boards: List<List<List<Int>>>) = boards
        .map { winRows ->
            val winCols = List(5) { mutableListOf<Int>() }
            for (i in 0..4) {
                for (j in 0..4) {
                    winCols[j].add(i, winRows[i][j])
                }
            }
            winRows.plus(winCols)
        }

    private fun sumOfUnmarked(board: List<List<Int>>, activeNumbers: List<Int>) =
        board.flatten().filterNot(activeNumbers::contains).sum()
}

fun main() {
    val input = FileReader.content("/day04/input.txt")
    println(Part2.result(input))
}

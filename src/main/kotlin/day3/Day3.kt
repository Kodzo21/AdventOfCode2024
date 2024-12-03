package day3

import java.io.File

private val regex = Regex("mul\\((\\d+),(\\d+)\\)")
private val dontDoRegex =  Regex("don't\\(\\)(.*?)do\\(\\)", RegexOption.DOT_MATCHES_ALL)
private val dontRegex = Regex("don't\\(\\)(.*?)",RegexOption.DOT_MATCHES_ALL)

private fun part1(input: String) {
    val result =
        regex.findAll(input).sumOf { match ->
            val (x, y) = match.destructured
            x.toInt() * y.toInt()

        }
    println(result)
}

private fun part2(input:String){
    val newInput = dontDoRegex.replace(input, "")
    //in some cases last don't() might not be removed
    //val newInput2 = dontRegex.replace(newInput, "")
    val result = regex.findAll(newInput).sumOf { match ->
        val (x, y) = match.destructured
        x.toInt() * y.toInt()
    }
    println(result)
}

fun main() {
    //read file
    val file = "src/main/kotlin/day3/input_day3"
    val input = File(file).readText()
    part1(input)
    part2(input)
}
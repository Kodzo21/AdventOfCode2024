package day2

import java.io.File
import kotlin.math.absoluteValue

fun part1(reports: List<List<Int>>) {
    val result = reports.count { report ->
        report.isSafe()
    }
    println(result)
}

fun part2(reports: List<List<Int>>) {
    val result = reports.count { line ->
        line.indices.any { i ->
            line.filterIndexed { idx, _ -> idx != i }.isSafe()
        }
    }
    println(result)
}

private fun List<Int>.isSafe() = (this.sorted() == this || this.sortedDescending() == this) &&
        this.zipWithNext().all { (it.first - it.second).absoluteValue in 1..3 }

fun main() {
    val input = File("src/main/kotlin/day2/input_day2").readLines()
    val reports = input.map { line ->
        line.split(" ").map { it.toInt() }
    }
    part1(reports)
    part2(reports)
}